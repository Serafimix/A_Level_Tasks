package ua.rakhmail.hw15.Task02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    Set<Box> boxSet;

    @BeforeEach
    void setUp() {
        boxSet = new TreeSet<>(new Box.BoxComparator());
    }

    @Test
    void fillSet() {


    }

    // пустой, 1 элем, нормальнй, проверка  последованности,
}