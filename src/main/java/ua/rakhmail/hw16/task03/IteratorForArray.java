package ua.rakhmail.hw16.task03;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorForArray<T> implements Iterator<T> {
    private final T[] array;
    private int position = 0;

    public IteratorForArray(T[] array) {
        this.array = array;
    }

    public T next() throws NoSuchElementException {
        if (hasNext())
            return array[position++];
        else
            throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return position < array.length;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}