package ua.rakhmail.hw12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

class Task03Test {
    String[] strings = {"Some", "Text", "For", "Tes"};
    Task03 testObject;


    @BeforeEach
    void setUp() {
        testObject = new Task03();
    }

    @Test
    @DisplayName("to much exceptions but without exception")
    void toMuchExceptionButWithoutException() {
        Assertions.assertEquals('r', testObject.toMuchExceptions(1, strings));
    }

    @Test
    @DisplayName("to much exceptions and expect My arithmetic exception")
    void toMuchExceptionArithmetic() {
        assertThrows(MyArithmeticExc.class, () -> testObject.toMuchExceptions(0, strings));
    }

    @Test
    @DisplayName("to much exceptions and expect Not In Array Exc")
    void toMuchExceptionNotInArrayException() {
        assertThrows(NotInArrayExc.class, () -> testObject.toMuchExceptions(50, strings));
        assertThrows(NotInArrayExc.class, () -> testObject.toMuchExceptions(4, strings));
        assertThrows(NotInArrayExc.class, () -> testObject.toMuchExceptions(3, strings));
    }

    @Test
    @DisplayName("to much exceptions and expect My arithmetic exception")
    void toMuchExceptionNotInStringException() {
        assertThrows(NotInStringExc.class, () -> testObject.toMuchExceptions(2, strings));
    }
}