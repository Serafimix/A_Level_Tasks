package ua.rakhmail.hw10.Students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testGetScholarshipWithInteger() {
        Student aspirant1 = new Student("", "", "", 4);
        Student aspirant2 = new Student("", "", "", 5);
        Student aspirant3 = new Student("", "", "", 1);
        Student aspirant4 = new Student("", "", "", 0);
        Assertions.assertEquals(80, aspirant1.getScholarship());
        Assertions.assertEquals(100, aspirant2.getScholarship());
        Assertions.assertEquals(80, aspirant3.getScholarship());
        Assertions.assertEquals(80, aspirant4.getScholarship());
    }

    @Test
    void testGetScholarshipWithDouble() {
        Student aspirant1 = new Student("", "", "", 5.1);
        Student aspirant2 = new Student("", "", "", 4.9);
        Student aspirant3 = new Student("", "", "", 5.0);
        Student aspirant4 = new Student("", "", "", 0.5);
        Assertions.assertEquals(80, aspirant1.getScholarship());
        Assertions.assertEquals(80, aspirant2.getScholarship());
        Assertions.assertEquals(100, aspirant3.getScholarship());
        Assertions.assertEquals(80, aspirant4.getScholarship());
    }
}