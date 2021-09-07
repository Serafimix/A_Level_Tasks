package ua.rakhmail.hw12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneBookTest {
    static final String[] PHONE_BOOK = new String[3];
    PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        String trueNumber = "016/161616";
        phoneBook = new PhoneBook();
        PHONE_BOOK[0] = "016/161616";
        PHONE_BOOK[1] = "016/161617";
        PHONE_BOOK[2] = "016/161618";
    }

    @Test
    void findIndexByPhoneNumber() {
    }
}