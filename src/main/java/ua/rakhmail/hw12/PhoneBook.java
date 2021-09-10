package ua.rakhmail.hw12;

import java.util.Arrays;
import java.util.Optional;

class PhoneBook {
    private static final String[] PHONE_BOOK = new String[3];

    public static void main(String[] args) {

        PHONE_BOOK[0] = "016/161616";
        PHONE_BOOK[1] = "016/161617";
        PHONE_BOOK[2] = "016/161618";
        System.out.println("Index of number 016/161617 = " +
                findIndexByPhoneNumber(PHONE_BOOK, "016/161617"));
        System.out.println("Search with null " + findIndexByPhoneNumber(PHONE_BOOK, null));
    }

    public static Optional<Integer> findIndexByPhoneNumber(String[] array, String phoneNumber) {
        Optional<Integer> number = Optional.of(Arrays.asList(array).indexOf(phoneNumber));
        return number.get() != -1 ? number : Optional.empty();
    }
}