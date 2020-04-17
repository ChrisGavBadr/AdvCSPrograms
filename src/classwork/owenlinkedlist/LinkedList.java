package classwork.owenlinkedlist;

public class LinkedList<E> {
    ListNode front;

    LinkedList(ListNode front) {
        this.front = front;
    }

    public LinkedList(E[] elementData) {
        if (elementData.length > 0) {
            front = new ListNode(elementData[0]);
            ListNode current = front;
            for (int i = 1; i < elementData.length; i++) {
                current.next = new ListNode(elementData[i]);
                current = current.next;
            }
        }
    }

    public ListNode getIndex(int i) {
        ListNode current = front;
        if (i < 0) {
            while (current.next != null) {
                current = current.next;
            }
        } else {
            int j = 0;
            while (j < i && current.next != null) {
                current = current.next;
                j++;
            }
            if (i != j) {
                throw new IndexOutOfBoundsException();
            }
        }

        return current;
    }

    public void addAll(int index, LinkedList<E> list) {
        getIndex(-1).next = list.front;
    }

    public void addAll(LinkedList<E> list) {
        ListNode current = front;
        while (current.next != null) {
            current = current.next;
        }
        for (int i = 0; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
    }

    public E get(int idx) {
        return (E) nodeAt(idx).data;
    }

    private ListNode nodeAt(int idx) {
        ListNode current = front;
        for (int i = 0; i < idx; i++) {
            current = current.next;
        }
        return current;
    }

    public boolean containsAll(LinkedList<E> list) {
        ListNode key = list.front;
        boolean have;

        do {
            have = this.contains(key);
            key = key.next;
        } while (!have && key != null);

        return have;
    }

    public boolean contains(Object o) {
        ListNode current = front;
        boolean have;

        do {
            have = current.data == o;
            current = current.next;
        } while (!have && current != null);

        return have;
    }


    public boolean equals(LinkedList<E> list) {
        ListNode current = front;
        ListNode other = list.front;
        boolean equal;

        do {
            equal = current.data == other.data;
            current = current.next;
            other = other.next;
        } while (equal && current.next != null);

        return equal;
    }

    public int lastIndexOf(Object o) {
        ListNode current = front;
        int index = 0;
        int indexof = -1;


        do {
            if (current.data == o) {
                indexof = index;
            }
            current = current.next;
            index++;
        } while (current != null);

        return indexof;
    }


    public boolean remove(Object o) {
        ListNode current = front;

        //edge case for an empty list
        if (current == null) {
            return false;
        }

        //edge case for removing the first element in the list
        //this also happens to work on a one element list
        if (current.data == o) {
            front = current.next;
            return true;
        }

        while (current.next != null) {
            if (current.next.data == o) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void removeAllOf(Object o) {
        ListNode current = front;

        //edge case for an empty list
        if (current == null) {
            return;
        }

        //edge case for removing the first element in the list
        //this also happens to work on a one element list
        if (current.data.equals(o)) {
            front = current.next;
            return;
        }

        while (current.next != null) {
            if (current.next.data.equals(o)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void removeAll(LinkedList<E> list) {
        ListNode thingToRemove = list.front;

        do {
            this.removeAllOf(thingToRemove.data);
            thingToRemove = thingToRemove.next;
        } while (thingToRemove != null);
    }

    //I am kind of proud of this method because the hard copy propagates through all elements of the list
    public LinkedList<E> hardCopy() {
        return new LinkedList<E>(front.hardCopy());
    }

    //This one was the most challenging for me, but I think think I found a very elegant solution in the end!
    //This uses a sort of double negative approach to the problem. Without thinking about it too hard my gut instinct
    // is telling me this is as efficient as retaining all directly.
    public void retainAll(LinkedList<E> list) {
        LinkedList<E> toRemove = this.hardCopy();
        toRemove.removeAll(list);
        this.removeAll(toRemove);
    }

    public int size() {
        ListNode current = front;
        int size = 0;

        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }

    public Object[] toArray() {
        ListNode current = front;

        Object[] array = new Object[this.size()];

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = current.data;
            current = current.next;
        }

        return array;
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
