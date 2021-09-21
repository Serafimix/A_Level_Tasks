package ua.rakhmail.hw16.students;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private int grade;

    List<Student> listOfStudents = new ArrayList<>();
    public Student(String name, String group, int course, int grade) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grade = grade;
    }

    public void kickAllDump (List<Student> list) {

    }
}
