package ua.rakhmail.hw15.Task01;

public class MyList<E> {
    private MyNode<E> head = new MyNode<>();
    private MyNode<E> tail = new MyNode<>();

    public void add(E value) {
        if (head.next == null) {
            MyNode<E> node = new MyNode<>();
            node.value = value;
            head.next = node;
        }
        if (tail.prev == null) {
            tail.prev = head.next;
            return;
        }
        MyNode<E> node = new MyNode<>();
        node.value = value;
        MyNode<E> lastNode = tail.prev;
        lastNode.next = node;
        node.prev = lastNode;
        tail.prev = node;
    }

    public E getFromLast(E value) {
        if (tail == null) {
            return null;
        } else if (tail == head) {
            return tail.value;
        }

        MyNode<E> previous = tail.prev;
        if (previous.value.equals(value)) {
            return previous.value;
        } else {
            while (previous.value != null) {
                if (previous.value.equals(value)) {
                    return previous.value;
                }
                previous = previous.prev;
            }
        }
        return null;
    }

    public static class MyNode<E> {
        private E value;
        private MyNode<E> next;
        private MyNode<E> prev;
    }
}


