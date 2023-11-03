import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

    }


    private Node first;
    private Node second;
    private Node last;
    private int size;


    // addLast
    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else  {
            last.next = node;
            last = node;
        }
        size++;
    }

    // addFirst
    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;

        }
        size++;
    }


    // contains
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }


    // indexOf
    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;

        }
        return -1;
    }


    // removeFirst
    public void removeFirst() {
        // [10 -> 20 -> 30]
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }


    // removeLast
    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        size--;
    }


    private Node getPrevious(Node node) {
        var current = first;
        while(current != null) {
            if (current.next == node) return current;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;


    }

    public int getKthFromTheEnd(int k) {
        if (k > 0) {
        var current = first.next;
        second = current.next;

        while (second != null) {
            var next = second.next;
            second = next;
        }
        return first.value;

        }
        return -1;
    }


    private boolean isEmpty() {
        return first == null;
    }

}
