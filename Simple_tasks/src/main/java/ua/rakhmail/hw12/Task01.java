package ua.rakhmail.hw12;

public class Task01 {
    public static void main(String[] args) {
        Exception exception = new Exception("Text");
        try {
            throw exception;
        } catch (Exception e) {
            System.out.println(exception);
        } finally {
            System.out.println("This is block of \"finally\"!");
        }
    }
}
