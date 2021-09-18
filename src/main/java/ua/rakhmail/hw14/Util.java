package ua.rakhmail.hw14;

import java.util.Arrays;
import java.util.List;

class Util<T> implements Multiplier<T> {
    T value;

    public void printHashCode(T e) {
        System.out.println("HashCode: " + e.hashCode());
    }

    public void save(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public T[] doubleValueIn(Number[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].doubleValue() * array[i].doubleValue();
        }
        return (T[]) Arrays.copyOf(array, array.length);
    }

    public <T extends Number> void sum(T one, T two) {
        System.out.println(one.doubleValue() + two.doubleValue());
    }

    public double sumOfArray(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    public void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}
