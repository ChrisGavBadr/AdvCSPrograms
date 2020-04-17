package classwork.owenlinkedlist;

public class ListNode<E> {
    E data;
    ListNode next;

    public ListNode(E data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(E data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode hardCopy() {
        if (next == null) {
            return new ListNode(this.data, next);
        } else {
            return new ListNode(this.data, next.hardCopy());
        }
    }
}