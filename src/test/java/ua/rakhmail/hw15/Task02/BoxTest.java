package ua.rakhmail.hw15.Task02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

class BoxTest {
    Set<Box> boxSet;
    Box box0;
    Box box00;
    Box boxMin5;
    Box box10;
    Box box2;
    Box.BoxComparator boxComparator;

    @BeforeEach
    void setUp() {
        boxMin5 = new Box(-5);
        box10 = new Box(10);
        box2 = new Box(2);
        box0 = new Box(0);
        box00 = new Box(0);
        boxSet = new TreeSet<>(new Box.BoxComparator());
        boxComparator = new Box.BoxComparator();
    }

    @Test
    void testComparatorWithZeroAndZero() {
        Assertions.assertEquals(-1, boxComparator.compare(box0, box00));
    }

    @Test
    void testComparatorWithNegativeNumberAndPositive() {
        Assertions.assertEquals(1, boxComparator.compare(boxMin5, box10));
    }

    @Test
    void testComparatorWithEqualsPositiveNumber() {
        Assertions.assertEquals(0, boxComparator.compare(box2, box2));
    }

    @Test
    void testComparatorWithDiferentPositiveNumber() {
        Assertions.assertEquals(1, boxComparator.compare(box2, box10));
    }

    @Test
    void testComparatorWithPositiveNumberAndNegativeNumber() {
        Assertions.assertEquals(-1, boxComparator.compare(box10, boxMin5));
    }
}