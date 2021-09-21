package ua.rakhmail.hw16.students;

import java.util.List;

public class Student {
    private final String name;
    private final String group;
    private int course;
    private double grade;

    public Student(String name, String group, int course, double grade) throws Exception {
        this.name = name;
        this.group = group;
        if (course >= 1 && course <= 6) {
            this.course = course;
        } else throw new Exception("There is only a course from 1 to 6");
        if (grade <= 5 && grade >= 1) {
            this.grade = grade;
        } else throw new Exception("There is only a grade from 1 to 5");
    }

    public static void kickAllDumps(List<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).grade < 3) {
                list.remove(i);
                i--;
            }
        }
        for (Student student : list) {
            if (student.course < 6) {
                student.course += 1;
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        for (var stu : students) {
            if (stu.course == course) {
                System.out.println(stu.name);
            }
        }
    }
}
