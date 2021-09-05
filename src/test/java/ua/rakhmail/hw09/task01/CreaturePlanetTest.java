package ua.rakhmail.hw09.task01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CreaturePlanetTest {
    private Earth earth1;
    private Earth earth2;
    private Earth earth3;
    private Mars mars;

    @BeforeEach
    void setUp() {
        earth1 = new Earth("Earth", 510000000L, true);
        earth2 = new Earth("Earth", 510000000L, true);
        earth3 = new Earth("Earth", 510000000L, true);
        mars = new Mars("Earth", 510000000L, true);
    }


    @Test
    @DisplayName("test hash code equals true")
    void testHashCodeEqualsTrue() {
        assertEquals(earth1.hashCode(), earth2.hashCode());
        assertEquals(earth2.hashCode(), earth1.hashCode());
        assertEquals(earth1.hashCode(), earth3.hashCode());
        assertEquals(earth3.hashCode(), earth1.hashCode());
        assertEquals(earth2.hashCode(), earth3.hashCode());
        assertEquals(earth3.hashCode(), earth2.hashCode());
        assertEquals(earth1.hashCode(), mars.hashCode());
        assertEquals(earth2.hashCode(), mars.hashCode());
        assertEquals(earth3.hashCode(), mars.hashCode());
        assertEquals(mars.hashCode(), mars.hashCode());
        assertEquals(mars.hashCode(), earth1.hashCode());
        assertEquals(mars.hashCode(), earth2.hashCode());
        assertEquals(mars.hashCode(), earth3.hashCode());
    }

    @Test
    @DisplayName("test equals true")
    void testEqualsTrue() {
        assertEquals(earth1, earth2);
        assertEquals(earth2, earth3);
        assertEquals(earth1, earth1);
        assertEquals(earth3, earth2);
        assertEquals(earth2, earth1);
    }

    @Test
    @DisplayName("test equals false")
    void testEqualsFalse() {
        assertNotEquals(earth1, mars);
        assertNotEquals(earth2, mars);
        assertNotEquals(earth3, mars);
        assertNotEquals(mars, earth1);
        assertNotEquals(mars, earth2);
        assertNotEquals(mars, earth3);
    }
}