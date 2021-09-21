package ua.rakhmail.hw16.students;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private double grade;

    List<Student> listOfStudents = new ArrayList<>();

    public Student(String name, String group, int course, double grade) {
        this.name = name;
        this.group = group;
        if (course >= 1 && course <= 6) {
            this.course = course;
        }
        if (grade > 5) {
            this.grade = grade;
        }
    }

    public void kickAllDump(List<Student> list) {
        for (var stu : list) {
            if (stu.grade < 3) {
                list.remove(stu);
            } else if (stu.grade >= 3 && stu.course < 6) {
                stu.course += 1;
            }
        }
    }

    public void printStudents(List<Student> students, int course){
        for (var stu : students){
            if (stu.course == course){
                System.out.println(stu.name);
            }
        }
    }
}
