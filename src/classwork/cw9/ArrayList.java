package classwork.cw9;

import java.util.Arrays;
import java.util.List;

public class ArrayList<E> {
    private E[] elementData;
    private int size;
    private int capacity;

    public ArrayList() {
        this(100);
    }

    public ArrayList(E[] elementData) {
        this();
        size = elementData.length;
        for (int i = 0; i < size; i++) {
            this.elementData[i] = elementData[i];
        }
    }

    public ArrayList(List<E> elementData) {
        this();
        size = elementData.size();
        for (int i = 0; i < size; i++) {
            this.elementData[i] = elementData.get(i);
        }
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        elementData = (E[]) (new Object[capacity]);
    }

    private void checkIndex(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + idx);
        }
    }

    public void add(E value) {
        elementData[size] = value;
        size++;
    }

    public void add(int idx, E value) {
        checkIndex(idx);
        for (int i = size; i > idx; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[idx] = value;
    }

    public void addAll(ArrayList<E> list) {
        for (int i = size; i < size + list.size(); i++) {
            elementData[i] = list.get(i - size);
        }
        size += list.size();
    }

    public void addAll(int idx, ArrayList<E> list) {
        checkIndex(idx);
        for (int i = size - 1; i >= idx; i--) {
            elementData[i + list.size()] = elementData[i];
        }
        for (int i = idx; i < idx + list.size(); i++) {
            elementData[i] = list.get(i - idx);
        }
        size += list.size();
    }

    public void remove() {
        remove(0);
    }

    public E remove(int idx) {
        checkIndex(idx);
        E removed = elementData[idx];
        for (int i = idx; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        elementData[size] = null;
        return removed;
    }

    public boolean remove(E value) {
        int idx = indexOf(value);
        if (idx != -1) {
            for (int i = idx; i < size; i++) {
                elementData[i] = elementData[i + 1];
            }
            size--;
            return true;
        }
        return false;
    }

    public void removeAll(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            while (contains(list.get(i))) {
                remove(list.get(i));
            }
        }
    }

    public void retainAll(ArrayList<E> list) {
        for (int i = size - 1; i >= 0; i--) {
            if (!list.contains(elementData[i])) {
                remove(i);
            }
        }
    }

    public E get(int idx) {
        checkIndex(idx);
        return elementData[idx];
    }

    public void set(int idx, E value) {
        checkIndex(idx);
        elementData[idx] = value;
    }

    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    public boolean containsAll(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E[] toArray() {
        return elementData;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = (E) new Object();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList<?> arrayList = (ArrayList<?>) o;
        return size == arrayList.size &&
                capacity == arrayList.capacity &&
                Arrays.equals(elementData, arrayList.elementData);
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder result = new StringBuilder("[" + elementData[0]);
            for (int i = 1; i < size; i++) {
                result.append(", ").append(elementData[i]);
            }
            result.append("]");
            return result.toString();
        }
    }
}
