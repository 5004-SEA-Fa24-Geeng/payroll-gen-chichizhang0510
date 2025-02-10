package student;

/** 
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {

    /**
     * Expected number of fields in an Employee CSV record.
     */
    private static final int EMPLOYEE_CSV_FIELDS = 7;

    /**
     * Expected number of fields in a TimeCard CSV record.
     */
    private static final int TIMECARD_CSV_FIELDS = 2;

    private Builder() {
    }


     /**
     * Builds an employee object from a CSV string.
     * 
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     * 
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        String[] parts = csv.split(",");
        if (parts.length != EMPLOYEE_CSV_FIELDS) {
            System.out.println("Error: Invalid Employee Data.");
        }

        EmployeeType type = EmployeeType.valueOf(parts[0]);
        String name = parts[1];
        String id = parts[2];
        double payRate = Double.parseDouble(parts[3]);
        double pretaxDeductions = Double.parseDouble(parts[4]);
        double ytdEarnings = Double.parseDouble(parts[5]);
        double ytdTaxesPaid = Double.parseDouble(parts[6]);

        switch (type) {
            case HOURLY:
                return new HourlyEmployee(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
            case SALARY:
                return new SalaryEmployee(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
            default:
                return null;
        }
    }



   /**
     * Converts a TimeCard from a CSV String.
     * 
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] parts = csv.split(",");
        if (parts.length != TIMECARD_CSV_FIELDS) {
            return null;
        }

        String id = parts[0];
        double hoursWorked = Double.parseDouble(parts[1]);
        return new TimeCard(id, hoursWorked);
    }
}
