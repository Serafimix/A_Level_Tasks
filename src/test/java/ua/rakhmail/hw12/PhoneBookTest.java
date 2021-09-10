package ua.rakhmail.hw12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ua.rakhmail.hw12.PhoneBook.findIndexByPhoneNumber;

class PhoneBookTest {

    private final String[] PHONE_BOOK = new String[3];

    @BeforeEach
    void setUp() {
        PHONE_BOOK[0] = "016/161616";
        PHONE_BOOK[1] = "016/161617";
        PHONE_BOOK[2] = "016/161618";
    }

    @Test
    @DisplayName("Special exception with using .get()")
    void findIndexByPhoneNumberWithUsingGetTest() {
        assertThrows(NoSuchElementException.class, () -> findIndexByPhoneNumber(PHONE_BOOK, "notInnerNumber").get());
        assertThrows(NoSuchElementException.class, () -> findIndexByPhoneNumber(PHONE_BOOK, "016/161615").get());
        assertThrows(NoSuchElementException.class, () -> findIndexByPhoneNumber(PHONE_BOOK, "123456789").get());
    }

    @Test
    @DisplayName("Special true with using .get()")
    void findIndexByPhoneNumberWithUsingGetTrueTest() {
        Assertions.assertEquals(0, findIndexByPhoneNumber(PHONE_BOOK, "016/161616").get());
        Assertions.assertEquals(1, findIndexByPhoneNumber(PHONE_BOOK, "016/161617").get());
        Assertions.assertEquals(2, findIndexByPhoneNumber(PHONE_BOOK, "016/161618").get());
    }


    @Test
    void findIndexByPhoneNumberTrueTest() {
        Assertions.assertEquals(Optional.of(0), findIndexByPhoneNumber(PHONE_BOOK, "016/161616"));
        Assertions.assertEquals(Optional.of(1), findIndexByPhoneNumber(PHONE_BOOK, "016/161617"));
        Assertions.assertEquals(Optional.of(2), findIndexByPhoneNumber(PHONE_BOOK, "016/161618"));
    }

    @Test
    public void findIndexByPhoneNumberFalseTest() {
        Assertions.assertEquals(Optional.empty(), findIndexByPhoneNumber(PHONE_BOOK, "023/456789"));
        Assertions.assertEquals(Optional.empty(), findIndexByPhoneNumber(PHONE_BOOK, "asdfghhjk"));
        Assertions.assertEquals(Optional.empty(), findIndexByPhoneNumber(PHONE_BOOK, " <)(=)(> "));
    }

    @Test
    public void findIndexByPhoneNumberWithEmptyTest() {
        Assertions.assertEquals(Optional.empty(), findIndexByPhoneNumber(PHONE_BOOK, ""));
    }

    @Test
    public void findIndexByPhoneNumberWithNullTest() {
        Assertions.assertEquals(Optional.empty(), findIndexByPhoneNumber(PHONE_BOOK, null));
    }
}

