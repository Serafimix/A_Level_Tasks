package ua.rakhmail.hw10.Students;

public class Test {
    static Student[] students = new Student[5];

    public static void main(String[] args) {
        fillAuditory();
        getMoney();
        for (var stu : students){
            System.out.println(stu);
        }
//        Aspirant studentoAspiranto = (Aspirant) new Student("Наполеон", "Бонапарт", "Завоеватель", 4.5);
    }

    public static void getMoney() {
        for (var stu : students) {
            System.out.println(stu.getScholarship());
        }
    }

    public static void fillAuditory() {
        students[0] = new Student("Алеша", "Попович", "Богатырь", 1.5);
        students[1] = new Student("Добрыня", "Никитич", "Богатырь", 5.0);
        students[2] = new Student("Илья", "Муромец", "Богатырь", 4.9);
        students[3] = new Aspirant("Юлий", "Цезарь", "Тот ещё Конь", 2.3, "Как говорить с людьми.");
        students[4] = new Aspirant("Владимир", "Великий", "Князь", 5.0, "Как править княжеством.");

    }
}
