package ua.rakhmail.hw16.task03;

public class Main {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] strings = new String[]{"Bla", "Bla-bla", "Bla-bla-bla"};
        IteratorForArray numbers = new IteratorForArray(integers);
        while (numbers.hasNext()) {
            System.out.println(numbers.next());
        }
        System.out.println(System.lineSeparator() + "*************************************" + System.lineSeparator());
        IteratorForArray stringIterator = new IteratorForArray(strings);
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }
}
