package ua.rakhmail.hw15.Task03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

class ListToMapClassTest {
    Map<String, Integer> mapEmpty;
    List<String> listWithStringMany;
    List<String> listWithStringEmpty;
    List<String> listWithStringOne;
    List<Integer> listWithInteger;

    @BeforeEach
    void setUp() {
        Collections.addAll(listWithStringMany, "D", "Vi", "Alu", "Vlad", "Dracu");
        Collections.addAll(listWithInteger, 1, 12, 12);
        listWithStringOne.add("Vampire");
    }

    @Test
    void listToMapWhenAllGood() {

    }

    @Test
    void listToMapWithOneElement() {

    }

    @Test
    void listToMapWithNotString() {

    }

    @Test
    void listToMapWithNumbers() {

    }

    @Test
    void listToMap() {

    }

    /* 1 элем, пустой, не стринг, цифры, норм,
     */
}