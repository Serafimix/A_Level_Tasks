package ua.rakhmail.hw31.task01;

public class ThreadsForThread extends Thread {

    public void run() {

        try {
            while (!isInterrupted()) {
                System.out.println("Hello from " + getName());
                Thread.sleep(10000);
            }
        } catch (InterruptedException ignored) {
        }
    }

}
