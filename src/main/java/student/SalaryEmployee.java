package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a salaried employee.
 */
public class SalaryEmployee extends Employee {

    /**
     * Constructor for SalaryEmployee.
     *
     * @param name Employee name
     * @param id Employee ID
     * @param payRate Employee's salary pay rate
     * @param ytdEarnings Year-to-date earnings
     * @param ytdTaxesPaid Year-to-date taxes paid
     * @param pretaxDeductions Pretax deductions
     */
    public SalaryEmployee(String name, String id, double payRate,
                          double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    /**
     * Gets the employee type.
     *
     * @return The string "SALARY"
     */
    @Override
    public String getEmployeeType() {
        return "SALARY";
    }

    /**
     * Calculates the gross pay for the employee.
     *
     * @param hoursWorked The number of hours worked (not used for salaried employees)
     * @return The calculated gross pay
     */
    @Override
    protected double calculateGrossPay(double hoursWorked) {
        return this.getPayRate() / SALARY_PAY_PERIODS;
    }

    /**
     * Runs payroll for the salaried employee.
     *
     * @param hoursWorked Hours worked in the current pay period
     * @return The generated pay stub object
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }

        BigDecimal totalPay = BigDecimal.valueOf(calculateGrossPay(hoursWorked))
                .setScale(10, RoundingMode.HALF_UP);

        BigDecimal taxablePay = totalPay
                .subtract(BigDecimal.valueOf(this.getPretaxDeductions()))
                .setScale(10, RoundingMode.HALF_UP);

        BigDecimal taxes = taxablePay.multiply(new BigDecimal(TAX_RATE))
                .setScale(10, RoundingMode.HALF_UP);

        BigDecimal payAfterTax = taxablePay.subtract(taxes)
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal payAfterTax1 = taxablePay.subtract(taxes)
                .setScale(2, RoundingMode.DOWN);

        BigDecimal prevYTDEarnings = BigDecimal.valueOf(this.getYTDEarnings());
        BigDecimal prevYTDTaxesPaid = BigDecimal.valueOf(this.getYTDTaxesPaid());

        BigDecimal newYTDEarnings = prevYTDEarnings.add(payAfterTax1)
                .setScale(2, RoundingMode.DOWN);
        BigDecimal newYTDTaxesPaid = prevYTDTaxesPaid.add(taxes)
                .setScale(2, RoundingMode.HALF_UP);

        this.setYtdEarnings(newYTDEarnings.doubleValue());
        this.setYtdTaxesPaid(newYTDTaxesPaid.doubleValue());

        return new PayStub(this.getName(),
                payAfterTax.doubleValue(), taxes.doubleValue(),
                newYTDEarnings.doubleValue(), newYTDTaxesPaid.doubleValue()
        );
    }

}
