package classwork.cw10;

class ListNode<E> {
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
}
