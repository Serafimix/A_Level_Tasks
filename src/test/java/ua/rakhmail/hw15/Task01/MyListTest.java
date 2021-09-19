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

    // проверка работоспособности.
}