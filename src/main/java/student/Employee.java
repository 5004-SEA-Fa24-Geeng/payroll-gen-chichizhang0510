package student;

/**
 * Abstract class Employee representing an employee's information.
 */
public abstract class Employee implements IEmployee {
    /**
     * Tax rate applied to the taxable income.
     */
    protected static final double TAX_RATE = 0.2265;

    /**
     * Extra rate for overtime pay calculation.
     */
    protected static final double OVERTIME_EXTRA_RATE = 0.5;

    /**
     * Standard number of hours considered for regular pay before overtime applies.
     */
    protected static final int REGULAR_HOURS = 40;

    /**
     * Number of pay periods in a salaried employee's yearly salary.
     */
    protected static final int SALARY_PAY_PERIODS = 24;

    /**
     * Employee name.
     */
    private String name;

    /**
     * Employee ID.
     */
    private String id;

    /**
     * Pay rate.
     */
    private double payRate;

    /**
     * Year-to-date earnings.
     */
    protected double ytdEarnings;

    /**
     * Year-to-date taxes paid.
     */
    protected double ytdTaxesPaid;

    /**
     * Pretax deductions.
     */
    private double pretaxDeductions;

    /**
     * Employee constructor.
     *
     * @param name Employee name
     * @param id Employee ID
     * @param payRate Pay rate
     * @param ytdEarnings Year-to-date earnings
     * @param ytdTaxesPaid Year-to-date taxes paid
     * @param pretaxDeductions Pretax deductions
     */
    public Employee(String name, String id, double payRate,
                    double ytdEarnings, double ytdTaxesPaid,
                    double pretaxDeductions) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public double getPayRate() {
        return payRate;
    }

    @Override
    public double getYTDEarnings() {
        return ytdEarnings;
    }

    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid;
    }

    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions;
    }

    public void setYtdTaxesPaid(double ytdTaxesPaid) {
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    public void setYtdEarnings(double ytdEarnings) {
        this.ytdEarnings = ytdEarnings;
    }

    /**
     * Runs payroll processing, calculates net pay, and updates YTD values.
     *
     * @param hoursWorked Hours worked in the current pay period
     * @return Generated pay stub object
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }

        double totalPay = calculateGrossPay(hoursWorked);
        double payShouldTax = totalPay - pretaxDeductions;
        double taxes = payShouldTax * TAX_RATE;
        double payAfterTax = payShouldTax - taxes;

        ytdEarnings += payAfterTax;
        ytdTaxesPaid += taxes;

        return new PayStub(name, payAfterTax, taxes, ytdEarnings, ytdTaxesPaid);
    }

    /**
     * Calculates gross pay (before deductions and taxes).
     *
     * @param hoursWorked Hours worked in the current pay period
     * @return Gross pay amount
     */
    protected abstract double calculateGrossPay(double hoursWorked);

    /**
     * Generates CSV-formatted employee information.
     *
     * @return CSV-formatted employee details
     */
    public String toCSV() {
        return getEmployeeType() + ","
                + name + ","
                + id + ","
                + payRate + ","
                + pretaxDeductions + ","
                + ytdEarnings + ","
                + ytdTaxesPaid;
    }
}
