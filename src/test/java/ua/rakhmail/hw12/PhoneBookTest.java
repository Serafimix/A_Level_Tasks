package ua.rakhmail.hw12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PhoneBookTest {

    private final String[] PHONE_BOOK = new String[3];
    private PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
        PHONE_BOOK[0] = "016/161616";
        PHONE_BOOK[1] = "016/161617";
        PHONE_BOOK[2] = "016/161618";
    }

    @Test
    @DisplayName("Special exception with using .get()")
    void findIndexByPhoneNumberWithUsingGetTest() {
        assertThrows(NoSuchElementException.class, () -> phoneBook.findIndexByPhoneNumber("notInnerNumber").get());
        assertThrows(NoSuchElementException.class, () -> phoneBook.findIndexByPhoneNumber("016/161615").get());
        assertThrows(NoSuchElementException.class, () -> phoneBook.findIndexByPhoneNumber("123456789").get());
    }

    // массив из не тестового файла перекрывает массив обьявленный в тесте из-за создание обьекта класса
    // со своим обьявленным массивом, и при вызове метода всегда будет показывать пустым.
    // если сделать метод статическим и передавать туда массив в качестве аргумента в параметрах то всё будет работать,

//    @Test
//    @DisplayName("Special true with using .get()")
//    void findIndexByPhoneNumberWithUsingGetTrueTest() {
//        Assertions.assertEquals(0, phoneBook.findIndexByPhoneNumber("016/161616").get());
//        Assertions.assertEquals(1, phoneBook.findIndexByPhoneNumber("016/161617").get());
//        Assertions.assertEquals(2, phoneBook.findIndexByPhoneNumber("016/161618").get());
//    }

//
//    @Test
//    void findIndexByPhoneNumberTrueTest() {
//        Assertions.assertEquals(Optional.of(0), phoneBook.findIndexByPhoneNumber("016/161616"));
//        Assert.assertEquals(Optional.of(1), findIndexByPhoneNumber(PHONE_BOOK, "016/161617"));
//        Assert.assertEquals(Optional.of(2), findIndexByPhoneNumber(PHONE_BOOK, "016/161618"));
//    }
//    @Test
//    public void findIndexByPhoneNumberFalseTest() {
//        Assert.assertEquals(Optional.empty(), findIndexByPhoneNumber(PHONE_BOOK, "023/456789"));
//        Assert.assertEquals(Optional.empty(), findIndexByPhoneNumber(PHONE_BOOK, "asdfghhjk"));
//        Assert.assertEquals(Optional.empty(), findIndexByPhoneNumber(PHONE_BOOK, " <)(=)(> "));
//    }
//
//    @Test
//    public void findIndexByPhoneNumberWithEmptyTest() {
//        Assert.assertEquals(Optional.empty(), findIndexByPhoneNumber(""));
//    }
//    @Test
//    public void findIndexByPhoneNumberWithNullTest() {
//        Assert.assertEquals(Optional.empty(), findIndexByPhoneNumber(null));
//    }


}