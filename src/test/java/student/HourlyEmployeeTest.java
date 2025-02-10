//package student;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class HourlyEmployeeTest {
//
//    private HourlyEmployee employee;
//
//    @BeforeEach
//    void setUp() {
//        employee = new HourlyEmployee("Chichi Zhang", "123456", 20.0, 5000.0, 1000.0, 200.0);
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
//        assertEquals(20.0, employee.getPayRate());
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
//        assertEquals("HOURLY", employee.getEmployeeType());
//    }
//
//    @Test
//    void runPayroll() {
//        IPayStub stub = employee.runPayroll(40);
//        assertNotNull(stub);
//        assertEquals((20 * 40 - 200) * (1 - 0.2265), stub.getPay(), 0.01);
//        assertEquals((20 * 40 - 200) * 0.2265, stub.getTaxesPaid(), 0.01);
//    }
//
//    @Test
//    void toCSV() {
//        String expected = "HOURLY,Chichi Zhang,123456,20.0,200.0,5000.0,1000.0";
//        assertEquals(expected, employee.toCSV());
//    }
//}