package ua.rakhmail.hw15.Task03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class ListToMapClassTest {
    Map<String, Integer> mapEmpty;
    List<String> listOfStringAllGood;
    List<String> listWithStringManyNumbers;
    List<String> listWithStringEmpty;
    List<String> listWithStringOne;
    List<Integer> listWithInteger;

    @BeforeEach
    void setUp() {
        listWithStringOne = new ArrayList<>();
        listWithStringOne.add("  One  ");
        listWithInteger = new ArrayList<>();
        listOfStringAllGood = new ArrayList<>();
        listWithStringEmpty = new ArrayList<>();
        listWithStringManyNumbers = new ArrayList<>();
        listWithStringManyNumbers.add(" 123  ");
        listOfStringAllGood.add("English");
    }

    @Test
    void listToMapWhenAllGoodWork() {
        mapEmpty = ListToMapClass.listToMap(listOfStringAllGood);
        Assertions.assertEquals(Optional.of(7), Optional.ofNullable(mapEmpty.get("English")));
    }

    @Test
    void listToMapWithOneElement() {
        mapEmpty = ListToMapClass.listToMap(listWithStringOne);
        Assertions.assertEquals(Optional.of(3), Optional.ofNullable(mapEmpty.get("  One  ")));
    }

    @Test
    void listToMapWithNumbers() {
        mapEmpty = ListToMapClass.listToMap(listWithStringManyNumbers);
        Assertions.assertEquals(Optional.of(0), Optional.ofNullable(mapEmpty.get(" 123  ")));
    }

    @Test
    void listToMapWithEmptyList() {
        mapEmpty = ListToMapClass.listToMap(listWithStringEmpty);
        Assertions.assertTrue(mapEmpty.isEmpty());
    }
}