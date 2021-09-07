package ua.rakhmail.hw12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class Task01Test {
    private Exception exception;

    @BeforeEach
    void setUp() {
        exception = new Exception("Text of exception");
    }

    @Test
    void main() {
        assertNotEquals("java.lang.Exception: Text of exception", exception);
    }
}