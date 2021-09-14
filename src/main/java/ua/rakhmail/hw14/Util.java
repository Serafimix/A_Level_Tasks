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
    public Object[] doubleValueIn(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i];
        }
        return array;
    }

    public void sum(Object one, Object two) { // should work only with numbers
        System.out.println(one + two);
    }

    public double sumOfArray(List<Object> list) {
        double s = 0.0;
        for (Object n : list) {
            s += n;
        }
        return s;
    }

    public void addNumbers(List<Object> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}



