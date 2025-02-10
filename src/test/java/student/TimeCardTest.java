//package student;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TimeCardTest {
//
//    private TimeCard timeCard;
//
//    @BeforeEach
//    void setUp() {
//        timeCard = new TimeCard("123456", 40.5);
//    }
//
//    @Test
//    void getEmployeeID() {
//        assertEquals("123456", timeCard.getEmployeeID());
//    }
//
//    @Test
//    void getHoursWorked() {
//        assertEquals(40.5, timeCard.getHoursWorked(), 0.01);
//    }
//
//    @Test
//    void testToString() {
//        String expected = "TimeCard{employeeID='123456', hoursWorked=40.5}";
//        assertEquals(expected, timeCard.toString());
//    }
//}