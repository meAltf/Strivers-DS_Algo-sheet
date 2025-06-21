private static Node removeByElement(Node head, int element) {
        if (head == null) return null;
        if (head.data == element) return head.next;

        Node temp = head, prev = null;
        while (temp != null) {
            if (temp.data == element) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
}
