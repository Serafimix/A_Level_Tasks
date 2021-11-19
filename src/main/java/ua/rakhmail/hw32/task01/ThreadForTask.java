package ua.rakhmail.hw32.task01;

import javassist.bytecode.analysis.Executor;
import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadForTask extends Thread {
private static volatile int number;

    public ThreadForTask(int number) {
        ThreadForTask.number = number;
    }

    @Override
    public void run() {
        Lock lock = new ReentrantLock();
        lock.lock();
        number = number+2;
        lock.unlock();
    }

    public static int getNumber() {
        return number;
    }
}
