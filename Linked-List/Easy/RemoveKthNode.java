private static Node removeKthNode(Node head, int k) {
        if (head == null || lengthLL(head) < k) return head;

        if (k == 1) return head.next;
        // 1 2 3 4 5 6 : k = 4
        int count = 1;
        Node temp = head;
        while (temp.next != null && count < k - 1) {
            count++;
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
}

// Approach -2 

private static Node removeKthNode2(Node head, int k) {
        if (head == null) return head;

        if (k == 1) return head.next;

        int count = 0;
        Node temp = head, prev = null;
        while (temp.next != null) {
            count++;
            if (count == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
