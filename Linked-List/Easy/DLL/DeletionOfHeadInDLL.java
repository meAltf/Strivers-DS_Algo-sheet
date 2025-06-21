 private static Node deleteHeadOfDLL(Node head) {
        if (head == null || head.next == null) return null;

        Node prev = head;
        head = head.next;

        head.back = null;
        prev.next = null;

        return head;
}
