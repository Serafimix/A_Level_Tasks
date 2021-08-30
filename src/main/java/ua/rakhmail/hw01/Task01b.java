package ua.rakhmail.hw01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*  А в данном примере идёт проверка на вводимые данные
    Это пример плохого кода. Написанный по принципу "РАБОТАЕТ, НЕ ТРОГАТЬ".
*/

public class Task01b {
    private static final String itsNumber = "Вы ввели: ";
    private static final String itsReversNumber = "А в обратном подрядке получится: ";
    private static final String ERROR = "Давай по новой, Юзер. Всё не то.";


    public static void main(String[] args) {
        System.out.println("Введите целое число.");
        try (Scanner sc = new Scanner(System.in)) {
            if (sc.hasNextLong()) {
                long number = sc.nextLong();
                if (number < 0) {
                    reversNegativeNumber(number);
                } else {
                    reversPositiveNumber(number);
                }
            } else if (sc.hasNextDouble())
                System.out.println("Попробуйте ввести целое число");
            else
                System.out.println(ERROR);
        }
    }


    // Расписываем преобразование целого числа в коллекцию чисел. (потом сделать его отдельным классом)

    public static List<Long> numberToList(long number) {
        String numberIn = Long.toString(number);               //Представляем число как строку
        char[] charArray = numberIn.toCharArray();             //Разбиваем строку числа на символы
        ArrayList<Long> charToLong = new ArrayList<Long>();    //С коллекцией проще работать, проще развернуть.
        for (int i = 0; i < charArray.length; i++) {           //Заполняем коллекцию
            long c = Character.getNumericValue(charArray[i]);  //С преобразованием символа в цифру
            charToLong.add(c);
        }
        return charToLong;
    }

    //Расспиываем разворот числа и вывод его в консоль с учетом положительного или отрицательного значения.

    public static void reversNegativeNumber(long number) {
        System.out.print(itsNumber + System.lineSeparator() + number);
        number *= -1;
        List<Long> numbers = numberToList(number);
        Collections.reverse(numbers);
        System.out.println(System.lineSeparator() + itsReversNumber);
        System.out.print("-");
        numbers.forEach(System.out::print);
    }

    public static void reversPositiveNumber(long number) {
        System.out.print(itsNumber + System.lineSeparator() + number);
        List<Long> numbers = numberToList(number);
        Collections.reverse(numbers);
        System.out.println(System.lineSeparator() + itsReversNumber);
        numbers.forEach(System.out::print);
    }
}