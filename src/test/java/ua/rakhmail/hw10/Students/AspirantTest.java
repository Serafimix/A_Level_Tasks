package ua.rakhmail.hw10.Students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AspirantTest {


    @Test
    void testGetScholarshipWithInteger() {
        Aspirant aspirant1 = new Aspirant("", "", "", 4, "");
        Aspirant aspirant2 = new Aspirant("", "", "", 5, "");
        Aspirant aspirant3 = new Aspirant("", "", "", 1, "");
        Aspirant aspirant4 = new Aspirant("", "", "", 0, "");
        Assertions.assertEquals(180, aspirant1.getScholarship());
        Assertions.assertEquals(200, aspirant2.getScholarship());
        Assertions.assertEquals(180, aspirant3.getScholarship());
        Assertions.assertEquals(180, aspirant4.getScholarship());
    }

    @Test
    void testGetScholarshipWithDouble() {
        Aspirant aspirant1 = new Aspirant("", "", "", 5.1, "");
        Aspirant aspirant2 = new Aspirant("", "", "", 4.9, "");
        Aspirant aspirant3 = new Aspirant("", "", "", 5.0, "");
        Aspirant aspirant4 = new Aspirant("", "", "", 0.5, "");
        Assertions.assertEquals(180, aspirant1.getScholarship());
        Assertions.assertEquals(180, aspirant2.getScholarship());
        Assertions.assertEquals(200, aspirant3.getScholarship());
        Assertions.assertEquals(180, aspirant4.getScholarship());
    }
}