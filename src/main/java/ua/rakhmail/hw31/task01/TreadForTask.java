package ua.rakhmail.hw31.task01;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TreadForTask extends Thread {
    static int count = 0;
    private final int countTread;

    public TreadForTask() {
        countTread = count++;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //            Thread.sleep(1000);
            System.out.println("Hello from" + this.getName());
        }

    }
}
