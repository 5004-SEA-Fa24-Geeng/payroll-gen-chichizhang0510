//package student;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PayStubTest {
//
//    private PayStub payStub;
//
//    @BeforeEach
//    void setUp() {
//        payStub = new PayStub("Chichi Zhang", 3500.75, 850.25, 10000.50, 2000.75);
//    }
//
//    @Test
//    void getPay() {
//        assertEquals(3500.75, payStub.getPay(), 0.01);
//    }
//
//    @Test
//    void getTaxesPaid() {
//        assertEquals(850.25, payStub.getTaxesPaid(), 0.01);
//    }
//
//    @Test
//    void toCSV() {
//        String expected = "Chichi Zhang,3500.75,850.25,10000.50,2000.75";
//        assertEquals(expected, payStub.toCSV());
//    }
//}