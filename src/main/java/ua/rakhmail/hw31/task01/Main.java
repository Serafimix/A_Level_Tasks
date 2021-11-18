package ua.rakhmail.hw31.task01;


public class Main {

    public static void main(String[] args) {
        try {
            ThreadForTask threadForTask = new ThreadForTask();
            System.out.println("Main thread started...");
            threadForTask.start();
        } catch (Exception e) {
            System.out.println("error in main thread");
        }
    }
}
