package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryEmployee extends Employee {

    public SalaryEmployee(String name, String id, double payRate,
                          double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    public String getEmployeeType() {
        return "SALARY";
    }

    @Override
    protected double calculateGrossPay(double hoursWorked) {
        return payRate / 24;
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }

        BigDecimal totalPay = BigDecimal.valueOf(calculateGrossPay(hoursWorked))
                .setScale(10, RoundingMode.HALF_UP);

        BigDecimal taxablePay = totalPay.subtract(BigDecimal.valueOf(pretaxDeductions))
                .setScale(10, RoundingMode.HALF_UP);

        BigDecimal taxes = taxablePay.multiply(new BigDecimal("0.2265"))
                .setScale(10, RoundingMode.HALF_UP);

        BigDecimal payAfterTax = taxablePay.subtract(taxes)
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal payAfterTax1 = taxablePay.subtract(taxes)
                .setScale(2, RoundingMode.DOWN);

        BigDecimal prevYTDEarnings = BigDecimal.valueOf(ytdEarnings);
        BigDecimal prevYTDTaxesPaid = BigDecimal.valueOf(ytdTaxesPaid);

        BigDecimal newYTDEarnings = prevYTDEarnings.add(payAfterTax1)
                .setScale(2, RoundingMode.DOWN);
        BigDecimal newYTDTaxesPaid = prevYTDTaxesPaid.add(taxes)
                .setScale(2, RoundingMode.HALF_UP);

        ytdEarnings = newYTDEarnings.doubleValue();
        ytdTaxesPaid = newYTDTaxesPaid.doubleValue();

        return new PayStub(name, payAfterTax.doubleValue(), taxes.doubleValue(), newYTDEarnings.doubleValue(), newYTDTaxesPaid.doubleValue());
    }

}
