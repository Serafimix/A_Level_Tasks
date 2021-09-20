package ua.rakhmail.hw15.Task01;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyListTest {
    MyList<String> list;


    @BeforeEach
    void setUp() {
        list = new MyList<>();
        list.add("5"); // head
        list.add("6");
        list.add("7");
        list.add("3");
        list.add("2"); // tail
    }

    @Test
    void add() {
        list.add("1"); //new tail.
    }

    @Test
    void getFromLastThrowNullEx() {
        Assert.assertThrows(NullPointerException.class, ()-> list.getFromLast("123"));
    }

    @Test
    void testLikeAMain() {
        Assertions.assertEquals("3", list.getFromLast("3"));
    }

    // проверка работоспособности.
}