package ua.rakhmail.hw03;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Task03 {

    public static void main(String[] args) {
        System.out.println("Введите строку, разделенную пробелами.");
        counterString();
    }

    public static void counterString (){
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine(), " ");
        while (tokenizer.hasMoreTokens()){
            tokenizer.nextToken();
            count++;
        }
        System.out.println("Вы ввели: "+count+" слов.");
        // тут ещё проверку впихнуть, если 1 слово, то слов = слово, два словА и т.д.
    }
}
