package ua.rakhmail.hw12;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Task02 testObject = new Task02();
        try (Scanner scanner = new Scanner(System.in)) {
            testObject.methodF(scanner.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void methodF(String text) throws Exception {
        try {
            System.out.println(methodG(text));
        } catch (StringIndexOutOfBoundsException e) {
            throw new Exception();
        }
    }

    public char methodG(String string) {
        if (string.length() < 1) {
            throw new StringIndexOutOfBoundsException();
        }
        return string.charAt(0);
    }
}
