package ua.rakhmail.hw12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task02Test {
    private Task02 testObject;

    @BeforeEach
    void setUp() {
        testObject = new Task02();
    }

    @Test
    @DisplayName("Test method G of Task02 with Exception")
    void methodGWithException() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> testObject.methodG(""));
    }

    @Test
    @DisplayName("Test method F of Task02 with Exception")
    void methodFWithException() {
        assertThrows(Exception.class, () -> testObject.methodF(""));
    }

    @ParameterizedTest
    @DisplayName("Test method G of Task02 when all good")
    @ValueSource(strings = {"asdf", "aqwer", "aqwer", "aPrint123", "a12354"})
    void methodGWhenAllGood(String string) {
        assertEquals('a', testObject.methodG(string));
    }

    @ParameterizedTest
    @DisplayName("Test method G of Task02 when all bad")
    @ValueSource(strings = {"asdf", "aqwer", "aqwer", "aPrint123", "a12354"})
    void methodGWhenAllBad(String string) {
        Assertions.assertNotEquals('0', testObject.methodG(string));
    }

}