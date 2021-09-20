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
    List<String> listWithStringManyNumbers;
    List<String> listWithStringEmpty;
    List<String> listWithStringOne;
    List<Integer> listWithInteger;


    @BeforeEach
    void setUp() {
        listWithStringOne = new ArrayList<>();
        listWithStringOne.add("One");
        listWithInteger = new ArrayList<>();
        listWithStringEmpty = new ArrayList<>();
        listWithStringManyNumbers = new ArrayList<>();
        listWithStringManyNumbers.add("123");
    }

    @Test
    void listToMapWhenAllGood() {

    }

    @Test
    void listToMapWithOneElement() {
        mapEmpty = ListToMapClass.listToMap(listWithStringOne);
        Assertions.assertEquals(Optional.of(3), Optional.ofNullable(mapEmpty.get("One")));
    }

    //    @Test
//    void listToMapWithNotString() {
//        Assert.assertThrows(new Exception(), () -> mapEmpty = ListToMapClass.listToMap(listWithInteger));
//    }
//
    @Test
    void listToMapWithNumbers() {
        mapEmpty = ListToMapClass.listToMap(listWithStringManyNumbers);
        Assertions.assertEquals(Optional.of(3), Optional.ofNullable(mapEmpty.get("123")));
    }

    @Test
    void listToMapWithEmptyList() {
        mapEmpty = ListToMapClass.listToMap(listWithStringEmpty);
        System.out.println("Преобразование пустого листа в мапу прошло успешно.");
        Assertions.assertTrue(mapEmpty.isEmpty());
    }

    /* 1 элем, пустой, не стринг, цифры, норм,
     */
}