package ua.rakhmail.hw10.Students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    private Student student5;
    private Student student6;
    private Student student7;
    private Student student8;

    @BeforeEach
    void setUp() {
        student1 = new Student("", "", "", 4);
        student2 = new Student("", "", "", 5);
        student3 = new Student("", "", "", 1);
        student4 = new Student("", "", "", 0);
        student5 = new Student("", "", "", 5.1);
        student6 = new Student("", "", "", 4.9);
        student7 = new Student("", "", "", 5.0);
        student8 = new Student("", "", "", 0.5);
    }

    @Test
    void testGetScholarshipWithInteger() {
        Assertions.assertEquals(80, student1.getScholarship());
        Assertions.assertEquals(100, student2.getScholarship());
        Assertions.assertEquals(80, student3.getScholarship());
        Assertions.assertEquals(80, student4.getScholarship());
    }

    @Test
    void testGetScholarshipWithDouble() {
        Assertions.assertEquals(80, student5.getScholarship());
        Assertions.assertEquals(80, student6.getScholarship());
        Assertions.assertEquals(100, student7.getScholarship());
        Assertions.assertEquals(80, student8.getScholarship());
    }
}