package ua.rakhmail.module02.market.marketServices;

public class UncorrectedLineWriter extends Exception {
    public UncorrectedLineWriter() {
        System.out.println("Incorrect Line Writer, need buy anything different, and client buy it ");
    }

    public UncorrectedLineWriter(String s) {
        super(s);
    }
}
