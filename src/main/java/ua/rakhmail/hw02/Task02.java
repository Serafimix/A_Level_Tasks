package ua.rakhmail.hw02;

public class Task02 {
    public static void main(String[] args) {
        double s = (squareOfTriangle(1, 1, 5, 4, 10, 4));
        System.out.println(s);
    }

    public static double squareOfTriangle(double ax, double ay, double bx, double by, double cx, double cy) {
        return Math.abs(ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2;
    }
}
