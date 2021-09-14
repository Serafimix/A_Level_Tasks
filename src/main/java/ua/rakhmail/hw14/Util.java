package ua.rakhmail.hw14;

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
    public Number[] doubleValueIn(Number[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (Integer) array[i] * (Integer) array[i];
        }
        return array;
    }

    public void sum(Integer one, Integer two) {
        System.out.println(one + two);
    }

    public double sumOfArray(List<Number> list) {
        double s = 0.0;
        for (Object n : list) {
            s += (Integer) n;
        }
        return s;
    }

    public void addNumbers(List<Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}
