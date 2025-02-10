package student;

import java.util.Locale;

/**
 * Represents a pay stub for an employee, containing details about the pay, taxes,
 * and year-to-date (YTD) information.
 * Implements the {@link IPayStub} interface to define pay stub behavior.
 */
public class PayStub implements IPayStub {
    /** The name of the employee associated with this pay stub. */
    private String name;

    /** The net pay (after taxes and deductions) for the current pay period. */
    private double payAfterTax;

    /** The total taxes paid for the current pay period. */
    private double tax;

    /** The year-to-date (YTD) earnings of the employee. */
    private double ytdEarnings;

    /** The year-to-date (YTD) taxes paid by the employee. */
    private double ytdTaxesPaid;

    /**
     * Constructs a new {@code PayStub} with the specified details.
     *
     * @param name The name of the employee.
     * @param payAfterTax The net pay for the current pay period.
     * @param tax The total taxes paid for the current pay period.
     * @param ytdEarnings The year-to-date earnings of the employee.
     * @param ytdTaxesPaid The year-to-date taxes paid by the employee.
     */
    public PayStub(String name, double payAfterTax, double tax, double ytdEarnings, double ytdTaxesPaid) {
        this.name = name;
        this.payAfterTax = payAfterTax;
        this.tax = tax;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    /**
     * Gets the net pay for the current pay period.
     *
     * @return The net pay after taxes and deductions.
     */
    @Override
    public double getPay() {
        return payAfterTax;
    }

    /**
     * Gets the total taxes paid for the current pay period.
     *
     * @return The total taxes paid.
     */
    @Override
    public double getTaxesPaid() {
        return tax;
    }

    /**
     * Converts the pay stub details to a CSV-formatted string.
     * The format follows: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid".
     *
     * @return A CSV string representing the pay stub.
     */
    @Override
    public String toCSV() {
        return name + ","
                + String.format(Locale.US, "%.2f", payAfterTax) + ","
                + String.format(Locale.US, "%.2f", tax) + ","
                + String.format(Locale.US, "%.2f", ytdEarnings) + ","
                + String.format(Locale.US, "%.2f", ytdTaxesPaid);
    }
}
