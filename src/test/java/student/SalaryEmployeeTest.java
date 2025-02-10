//package student;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SalaryEmployeeTest {
//
//    private SalaryEmployee employee;
//
//    @BeforeEach
//    void setUp() {
//        employee = new SalaryEmployee("Chichi Zhang", "123456", 48000.0, 5000.0, 1000.0, 200.0);
//    }
//
//    @Test
//    void getName() {
//        assertEquals("Chichi Zhang", employee.getName());
//    }
//
//    @Test
//    void getID() {
//        assertEquals("123456", employee.getID());
//    }
//
//    @Test
//    void getPayRate() {
//        assertEquals(48000.0, employee.getPayRate());
//    }
//
//    @Test
//    void getYTDEarnings() {
//        assertEquals(5000.0, employee.getYTDEarnings());
//    }
//
//    @Test
//    void getYTDTaxesPaid() {
//        assertEquals(1000.0, employee.getYTDTaxesPaid());
//    }
//
//    @Test
//    void getPretaxDeductions() {
//        assertEquals(200.0, employee.getPretaxDeductions());
//    }
//
//    @Test
//    void getEmployeeType() {
//        assertEquals("SALARY", employee.getEmployeeType());
//    }
//
//    @Test
//    void runPayroll() {
//        IPayStub stub = employee.runPayroll(40);
//        assertNotNull(stub);
//
//        double expectedTotalPay = 48000.0 / 24;
//        double expectedPayShouldTax = expectedTotalPay - 200;
//        double expectedTaxes = expectedPayShouldTax * 0.2265;
//        double expectedPayAfterTax = expectedPayShouldTax - expectedTaxes;
//
//        assertEquals(expectedPayAfterTax, stub.getPay(), 0.01);
//        assertEquals(expectedTaxes, stub.getTaxesPaid(), 0.01);
//    }
//
//
//    @Test
//    void toCSV() {
//        String expected = "SALARY,Chichi Zhang,123456,48000.0,200.0,5000.0,1000.0";
//        assertEquals(expected, employee.toCSV());
//    }
//}