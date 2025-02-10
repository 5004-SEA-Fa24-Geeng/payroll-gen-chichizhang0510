package student;

/**
 * Represents an hourly employee who is paid based on the number of hours worked.
 * Extends {@link Employee} to define common employee behavior.
 */
public class HourlyEmployee extends Employee {

    /**
     * Constructs a new {@code HourlyEmployee} with the specified details.
     *
     * @param name The name of the employee.
     * @param id The unique ID of the employee.
     * @param payRate The hourly pay rate.
     * @param ytdEarnings The year-to-date earnings.
     * @param ytdTaxesPaid The year-to-date taxes paid.
     * @param pretaxDeductions The pretax deductions.
     */
    public HourlyEmployee(String name, String id, double payRate,
                          double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    /**
     * Gets the employee type as a string.
     *
     * @return "HOURLY" indicating this employee is an hourly employee.
     */
    @Override
    public String getEmployeeType() {
        return "HOURLY";
    }

    /**
     * Calculates the gross pay based on hours worked.
     * - Standard hours (up to 40) are paid at the normal hourly rate.
     * - Overtime (above 40 hours) is paid at 1.5 times the hourly rate.
     *
     * @param hoursWorked The number of hours worked in the pay period.
     * @return The total gross pay before deductions and taxes.
     */
    @Override
    protected double calculateGrossPay(double hoursWorked) {
        double totalPay = payRate * hoursWorked;

        if (hoursWorked > REGULAR_HOURS) {
            double overtimeHours = hoursWorked - REGULAR_HOURS;
            double overtimePay = overtimeHours * (payRate * OVERTIME_EXTRA_RATE);
            totalPay += overtimePay;
        }

        return totalPay;
    }
}
