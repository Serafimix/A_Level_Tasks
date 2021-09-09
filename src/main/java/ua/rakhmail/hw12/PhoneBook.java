package ua.rakhmail.hw12;

import java.util.Arrays;
import java.util.Optional;

class PhoneBook {
    private static final String[] PHONE_BOOK = new String[3];

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        PHONE_BOOK[0] = "016/161616";
        PHONE_BOOK[1] = "016/161617";
        PHONE_BOOK[2] = "016/161618";
            System.out.println("Index of number 016/161617 = " +
                    phoneBook.findIndexByPhoneNumber("016/161617"));
        System.out.println("Search with null " + phoneBook.findIndexByPhoneNumber(null));
    }

    public Optional<Integer> findIndexByPhoneNumber(String phoneNumber) {
        Optional<Integer> number = Optional.of(Arrays.asList(PHONE_BOOK).indexOf(phoneNumber));
        return number.get() != -1 ? number : Optional.empty();
    }
}