package ua.rakhmail.hw03;

import java.util.Scanner;

public class Task02 {

    /*
    Примеры палиандромов.

    Лёша на полке клопа нашёл
    А роза упала на лапу Азора
    Аргентина манит негра
    Я иду съ мечемъ судия
    Я - арка края.
    О лета тело
    Молебен о коне белом
    Лег на храм и дивен и невидим архангел
    Искать такси
     */

    public static void main(String[] args) {
        String yourLine = addYouLine();
        String withoutSpace = deleterSpace(yourLine);
        System.out.println("Вы ввели \""+ yourLine + "\", а только буквами "+ withoutSpace);
        if (isPoliandr(yourLine)) {
            System.out.println("Слова \"" + yourLine + "\" являются палиндромом.");
        }
    }
    public static String addYouLine(){
        System.out.println("Введите свой текст:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String deleterSpace (String string){
        String withoutSpace = string.replaceAll("\\s","");
        String onlyLiters = withoutSpace.replaceAll("\\p{Punct}", ""); //удаление знаков пунктуации.
        return onlyLiters;
    }

    public static boolean isPoliandr (String string){
        return deleterSpace(string).equalsIgnoreCase(new StringBuilder(deleterSpace(string)).reverse().toString());
    }
}
