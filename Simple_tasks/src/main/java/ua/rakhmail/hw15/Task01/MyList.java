package ua.rakhmail.hw15.Task01;

public class MyList<E> {

    public static class MyNode<E> {
        private final E value;
        private MyNode<E> next;
        private MyNode<E> prev;

        public MyNode(E value) {
            this.value = value;
        }
    }

    private MyNode<E> head;
    private MyNode<E> tail;

    public void add(E value) {
        MyNode<E> myNode = new MyNode<>(value);
        if (head == null) {
            head = myNode;
        } else {
            MyNode<E> next = head.next;
            if (next == null) {
                head.next = myNode;
                myNode.prev = head;
            } else {
                while ( next.next != null ) {
                    next = next.next;
                }
                next.next = myNode;
                myNode.prev = next;
            }
        }
        tail = myNode;
    }

    public E getFromLast(E value) {
        if (tail == null) { // if 0 elements
            return null;
        } else if (tail == head) { // if 1 elements
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
}


