package ua.rakhmail.hw12;

import java.util.Arrays;
import java.util.Optional;

class PhoneBook {
    private static final String[] PHONE_BOOK = new String[3];
    private static final String stringTrue = "016/161617";
    private static String stringNull;

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        PHONE_BOOK[0] = "016/161616";
        PHONE_BOOK[1] = "016/161617";
        PHONE_BOOK[2] = "016/161618";
        System.out.println("Index of number " + stringTrue + " = " +
                phoneBook.findIndexByPhoneNumber(stringTrue));
        System.out.println("Search with null " + phoneBook.findIndexByPhoneNumber(stringNull));
    }

    public Optional<Integer> findIndexByPhoneNumber(String phoneNumber) {
        //знаю что можно это сделать одной строчкой, но я не понял как.
        Optional<Integer> number = Optional.of(Arrays.asList(PHONE_BOOK).indexOf(phoneNumber));
        if (number.get() != -1)
            return number;
        else return Optional.empty();
    }
}