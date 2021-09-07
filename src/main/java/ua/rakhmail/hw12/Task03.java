package ua.rakhmail.hw12;

public class Task03 {

    public static void main(String[] args) {
        String[] strings = {"Some", "Text", "For", "Test"};
        Task03 testObject = new Task03();
        try {
            System.out.println(testObject.toMuchExceptions(1, strings));
        } catch (MyArithmeticExc | NotInArrayExc | NotInStringExc e) {
            e.printStackTrace();
        }
    }

    public char toMuchExceptions(int n, String[] arrayOfString) {
        if (n == 0)
            throw new MyArithmeticExc();
        if (n >= arrayOfString.length - 1)
            throw new NotInArrayExc();
        if (n >= arrayOfString[n + 1].length() - 1)
            throw new NotInStringExc();
        int zero = n + 1 / n;
        return arrayOfString[n + 1].charAt(n + 1);
    }
}

class NotInArrayExc extends ArrayIndexOutOfBoundsException {

}

class NotInStringExc extends StringIndexOutOfBoundsException {

}

class MyArithmeticExc extends ArithmeticException {

}