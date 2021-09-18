package ua.rakhmail.hw15.Task03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ListToMapClassTest {
    Map<String, Integer> mapEmpty;
    List<String> listWithStringMany;
    List<String> listWithStringEmpty;
    List<String> listWithStringOne;
    List<Integer> listWithInteger;

    @BeforeEach
    void setUp() {
        Collections.addAll(listWithStringMany, "D", "Vi", "Alu", "Vlad", "Dracu");
        listWithStringOne.add("Vampire");
    }

    @Test
    void listToMap() {

    }

    /* 1 элем, пустой, не стринг, цифры, норм,
     */
}