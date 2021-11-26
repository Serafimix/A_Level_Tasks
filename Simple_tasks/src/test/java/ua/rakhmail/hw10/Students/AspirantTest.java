package ua.rakhmail.hw10.Students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AspirantTest {
    private Aspirant aspirant1;
    private Aspirant aspirant2;
    private Aspirant aspirant3;
    private Aspirant aspirant4;
    private Aspirant aspirant5;
    private Aspirant aspirant6;
    private Aspirant aspirant7;
    private Aspirant aspirant8;

    @BeforeEach
    void setUp() {
        aspirant1 = new Aspirant("", "", "", 4, "");
        aspirant2 = new Aspirant("", "", "", 5, "");
        aspirant3 = new Aspirant("", "", "", 1, "");
        aspirant4 = new Aspirant("", "", "", 0, "");
        aspirant5 = new Aspirant("", "", "", 5.1, "");
        aspirant6 = new Aspirant("", "", "", 4.9, "");
        aspirant7 = new Aspirant("", "", "", 5.0, "");
        aspirant8 = new Aspirant("", "", "", 0.5, "");
    }

    @Test
    void testGetScholarshipWithInteger() {
        Assertions.assertEquals(180, aspirant1.getScholarship());
        Assertions.assertEquals(200, aspirant2.getScholarship());
        Assertions.assertEquals(180, aspirant3.getScholarship());
        Assertions.assertEquals(180, aspirant4.getScholarship());
    }

    @Test
    void testGetScholarshipWithDouble() {
        Assertions.assertEquals(180, aspirant5.getScholarship());
        Assertions.assertEquals(180, aspirant6.getScholarship());
        Assertions.assertEquals(200, aspirant7.getScholarship());
        Assertions.assertEquals(180, aspirant8.getScholarship());
    }
}