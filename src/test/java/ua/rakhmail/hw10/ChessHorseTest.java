package ua.rakhmail.hw10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class ChessHorseTest {

    @Test
    void moveHorseGood() {
        assertTrue(ChessHorse.moveHorse("a1", "b3"));
        assertTrue(ChessHorse.moveHorse("H8", "G6"));
        assertTrue(ChessHorse.moveHorse("d4", "F5"));
    }

    @Test
    void moveHorseWrong() {
        assertFalse(ChessHorse.moveHorse("b4", "b4"));
        assertFalse(ChessHorse.moveHorse("g1", "e4"));
        assertFalse(ChessHorse.moveHorse("c1", "b8"));
    }

    @Test
    void moveHorseZeroPoint() {
        assertFalse(ChessHorse.moveHorse("",""));
    }

    @Test
    void moveHorseOnlyOneStep() {
        assertFalse(ChessHorse.moveHorse("a1", ""));
        assertFalse(ChessHorse.moveHorse("h8", ""));
        assertFalse(ChessHorse.moveHorse("g1", ""));
    }

    @Test
    void moveHorseOnlyTwoStep() {
        assertFalse(ChessHorse.moveHorse("", "a1"));
        assertFalse(ChessHorse.moveHorse("", "b4"));
        assertFalse(ChessHorse.moveHorse("", "h8"));
    }

    @Test
    void moveHorseSameLitters() {
        assertFalse(ChessHorse.moveHorse("asfd125", "a1asrg"));
        assertFalse(ChessHorse.moveHorse("a1asfwqr", "b3awwrwqr"));
        assertFalse(ChessHorse.moveHorse("124a", "15616b"));
    }
}