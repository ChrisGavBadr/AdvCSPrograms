package classwork.cw9;

import java.util.Arrays;
import java.util.List;

public class ArrayList<E> {
    private Object[] elementData;
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
        elementData = new Object[capacity];
    }

    private void checkIndex(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index: " + idx);
        }
    }

    public void add(Object o) {
        elementData[size] = o;
        size++;
    }

    public void add(int idx, Object o) {
        checkIndex(idx);
        for (int i = size; i > idx; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[idx] = o;
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

    public Object remove(int idx) {
        checkIndex(idx);
        Object removed = elementData[idx];
        for (int i = idx; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        elementData[size] = null;
        return removed;
    }

    public boolean remove(Object o) {
        int idx = indexOf(o);
        if (idx != -1) {
            for (int i = idx; i < size; i++) {
                elementData[i] = elementData[i + 1];
            }
            size--;
            return true;
        } else {
            return false;
        }
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

    public Object get(int idx) {
        checkIndex(idx);
        return elementData[idx];
    }

    public void set(int idx, Object o) {
        checkIndex(idx);
        elementData[idx] = o;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public boolean containsAll(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i].equals(o)) {
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

    public Object[] toArray() {
        return elementData;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = new Object();
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
