package classwork.cw10;

import java.util.*;

public class LinkedList<E> {
    private ListNode front;
    private int size;

    private ListNode nodeAt(int idx) {
        checkIndex(idx);
        ListNode current = front;
        for (int i = 0; i < idx; i++) {
            current = current.next;
        }
        return current;
    }

    public LinkedList() {
        front = null;
        size = 0;
    }

    public LinkedList(E[] elementData) {
        this();
        if (elementData.length > 0) {
            front = new ListNode(elementData[0]);
            size = elementData.length;
            ListNode current = front;
            for (int i = 1; i < elementData.length; i++) {
                current.next = new ListNode(elementData[i]);
                current = current.next;
            }
        }
    }

    public LinkedList(List<E> elementData) {
        this();
        if (!elementData.isEmpty()) {
            front = new ListNode((elementData.get(0)));
            size = elementData.size();
            ListNode current = front;
            for (int i = 1; i < elementData.size(); i++) {
                current.next = new ListNode(elementData.get(i));
                current = current.next;
            }
        }
    }

    private void checkIndex(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + idx);
        }
    }

    public void add(E value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = nodeAt(size - 1);
            current.next = new ListNode(value);
        }
        size++;
    }

    public void add(int idx, E value) {
        checkIndex(idx);
        if (idx == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(idx - 1);
            current.next = new ListNode(value, current.next);
        }
        size++;
    }

    public void addAll(LinkedList<E> list) {
        ListNode current = nodeAt(size - 1);
        for (int i = 0; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
            size++;
        }
    }

    public void addAll(int idx, LinkedList<E> list) {
        checkIndex(idx);
        ListNode temp = nodeAt(idx);
        ListNode current;
        if (idx == 0) {
            front = new ListNode(list.get(0));
            current = front;
            for (int i = 1; i < list.size(); i++) {
                current.next = new ListNode(list.get(i));
                current = current.next;
            }
        } else {
            current = nodeAt(idx - 1);
            for (int i = 0; i < list.size(); i++) {
                current.next = new ListNode(list.get(i));
                current = current.next;
            }
        }
        current.next = temp;
        size += list.size();
    }

    public void remove() {
        if (front == null) {
            throw new NoSuchElementException();
        } else {
            front = front.next;
            size--;
        }
    }

    public E remove(int idx) {
        checkIndex(idx);
        E removed;
        if (idx == 0) {
            removed = (E) front.data;
            front = front.next;
        } else {
            ListNode current = nodeAt(idx - 1);
            removed = (E) current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removed;
    }

    public boolean remove(E value) {
        if (front.data.equals(value)) {
            front = front.next;
            size--;
            return true;
        } else {
            ListNode current = front;
            while (current.next != null) {
                if (current.next.data.equals(value)) {
                    current.next = current.next.next;
                    size--;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public void removeAll(LinkedList<E> list) {
        ListNode current = front;
        while (current.next != null) {
            for (int i = 0; i < list.size(); i++) {
                if (current.next.data.equals(list.get(i))) {
                    current.next = current.next.next;
                    size--;
                }
            }
            if (current.next != null) {
                current = current.next;
            }
        }
        if (list.contains(front.data)) {
            front = front.next;
            size--;
        }
    }

    public void retainAll(LinkedList<E> list) {
        ListNode current = front;
        while (current.next != null) {
            if (!list.contains(current.next.data)) {
                current.next = current.next.next;
                size--;
            } else {
                current = current.next;
            }
        }
        if (!list.contains(front.data)) {
            front = front.next;
            size--;
        }
    }

    public E get(int idx) {
        return (E) nodeAt(idx).data;
    }

    public void set(int idx, E value) {
        nodeAt(idx).data = value;
    }

    public boolean contains(Object value) {
        ListNode current = front;
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean containsAll(LinkedList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int indexOf(Object value) {
        ListNode current = front;
        int idx = 0;
        while (current != null) {
            if (current.data.equals(value)) {
                return idx;
            }
            current = current.next;
            idx++;
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        ListNode current = front;
        int idx = 1;
        int lastIdx = -1;
        if (front.data.equals(value)) {
            lastIdx = 0;
        }
        while (current.next != null) {
            if (current.next.data.equals(value)) {
                lastIdx = idx;
            }
            current = current.next;
            idx++;
        }
        return lastIdx;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public Object[] toArray() {
        Object[] elementData = new Object[size];
        ListNode current = front;
        for (int i = 0; i < size; i++) {
            elementData[i] = current.data;
            current = current.next;
        }
        return elementData;
    }

    public void clear() {
        front = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList<?> that = (LinkedList<?>) o;
        if (size != that.size) return false;
        ListNode current = front;
        ListNode currentThat = that.front;
        while (current.next != null) {
            if (current.data != currentThat.data) {
                return false;
            }
            current = current.next;
            currentThat = currentThat.next;
        }
        return true;
    }

    @Override
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            StringBuilder result = new StringBuilder("[" + front.data);
            ListNode current = front.next;
            while (current != null) {
                result.append(", ").append(current.data);
                current = current.next;
            }
            result.append("]");
            return result.toString();
        }
    }
}