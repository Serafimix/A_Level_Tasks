package ua.rakhmail.hw15.Task01;

public class Test {


    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("3");
        list.add("0");
        System.out.println(list.getFromLast("7"));
    }
}
