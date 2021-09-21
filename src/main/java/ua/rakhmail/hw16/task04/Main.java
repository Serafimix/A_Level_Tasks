package ua.rakhmail.hw16.task04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student("Alesha", "Bogatyr", 1, 1.0));               //1c del
        listOfStudents.add(new Student("Dobryna", "Bogatyr", 3, 3.5));
        listOfStudents.add(new Student("Ilia", "Bogatyr", 6, 3.1));                 // 6c
        listOfStudents.add(new Student("Zmei Gorinych", "Fairytale", 2, 2.9));      //2c del
        listOfStudents.add(new Student("Tugarin", "Antogonists", 3, 4.5));
        listOfStudents.add(new Student("Kalyvan", "Antogonists", 5, 4.9));
        listOfStudents.add(new Student("Lubava", "Bogatyr", 4, 4.1));
        listOfStudents.add(new Student("Alena", "Bogatyr", 6, 3.0));                // 6c
        listOfStudents.add(new Student("Knyaz", "Antogonists", 5, 2.5));            //5c del
        listOfStudents.add(new Student("Gaius Iulius Caesar", "Horse", 4, 5.0));
        listOfStudents.add(new Student("Baba Yaga", "Fairytale", 2, 4.1));
        listOfStudents.add(new Student("Koshei", "Fairytale", 1, 4.4));
        listOfStudents.add(new Student("Wisp", "Fairytale", 2, 3.1));

        toStringStudents(listOfStudents);
        Student.kickAllDumps(listOfStudents);
        System.out.println("/////////////////////////////////////////////////////////////");
        System.out.println("Deduction of debtors");
        System.out.println("/////////////////////////////////////////////////////////////");
        toStringStudents(listOfStudents);
        System.out.println("/////////////////////////////////////////////////////////////");
        System.out.println("Raising excellent students");
        System.out.println("/////////////////////////////////////////////////////////////");
        Student.courseUpper(listOfStudents);
        toStringStudents(listOfStudents);
    }

    public static void toStringStudents(List<Student> list) {
        for (int i = 1; i <= 6; i++) {
            System.out.println("Course " + i);
            Student.printStudents(list, i);
            System.out.println("***********************");
        }
    }
}
