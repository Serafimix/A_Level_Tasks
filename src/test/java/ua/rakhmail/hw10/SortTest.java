package ua.rakhmail.hw10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortTest {

    @Test
    void isBiggerThenPastGood() {
        assertTrue(Sort.isBiggerThenPast(new int[]{100, 77, 23, 1, 1, -33}));
        assertTrue(Sort.isBiggerThenPast(new int[]{1, 0, -1, -1254, -125456, Integer.MIN_VALUE}));
        assertTrue(Sort.isBiggerThenPast(new int[]{0, 0, 0, 0, 0, -1}));
    }

    @Test
    void isBiggerThenPastBad() {
        assertFalse(Sort.isBiggerThenPast(new int[]{-124, 100, 77, 23, 1, 1, -33}));
        assertFalse(Sort.isBiggerThenPast(new int[]{-125, 1, 0, -1, -1254, -125456, Integer.MIN_VALUE}));
        assertFalse(Sort.isBiggerThenPast(new int[]{-124, 0, 0, 0, 0, 0, -1}));
    }

    @Test
    void isBiggerThenPastOneNumber() {
        assertTrue(Sort.isBiggerThenPast(new int[]{1}));
        assertTrue(Sort.isBiggerThenPast(new int[]{Integer.MIN_VALUE}));
        assertTrue(Sort.isBiggerThenPast(new int[]{Integer.MAX_VALUE}));
    }

    @Test
    void isBiggerThenPastNullArray() {
        assertTrue(Sort.isBiggerThenPast(new int[]{}));
        assertTrue(Sort.isBiggerThenPast(new int[]{}));
        assertTrue(Sort.isBiggerThenPast(new int[]{}));
    }

    @Test
    void isBiggerThenPastSameNumbers() {
        assertTrue(Sort.isBiggerThenPast(new int[]{1, 1, 1, 1, 1, 1, 1}));
        assertTrue(Sort.isBiggerThenPast(new int[]{0, 0, 0, 0, 0, 0, 0, 0}));
        assertTrue(Sort.isBiggerThenPast(new int[]{-1, -1, -1, -1, -1, -1}));
    }

}