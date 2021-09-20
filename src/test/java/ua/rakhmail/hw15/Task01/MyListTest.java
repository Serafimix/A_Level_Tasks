package ua.rakhmail.hw15.Task01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyListTest {

    MyList<Integer> myListAllBeGood;
    MyList<Integer> myListEmpty;
    MyList<Integer> myListEmptyForAddMethod;
    MyList<Integer> myListOneElement;

    @BeforeEach
    void setUp() {
        myListAllBeGood = new MyList<>();
        myListOneElement = new MyList<>();
        myListEmptyForAddMethod = new MyList<>();
    }

    @Test
    void add() {
    }

    @Test
    void getFromLast() {
    }

    @Test
    void testLikeAMain() {
        MyList<String> list = new MyList<>();
        list.add("5"); // head
        list.add("6");
        list.add("7");
        list.add("3");
        list.add("2"); // tail
        System.out.println(list.getFromLast("3"));
    }

    // проверка работоспособности.
}