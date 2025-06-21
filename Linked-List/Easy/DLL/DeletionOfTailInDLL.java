private static Node deleteTailOfDLL(Node head) {
        if (head == null || head.next == null) return null;

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node newTail = tail.back;
        newTail.next = null;
        tail.back = null;

        return head;
}
