private static Node insertionBeforeValue(Node head, int data, int insertData) {
        if (head == null) return null;

        if (head.data == insertData) {
            return new Node(data, head);
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == insertData) {
//                Node newNode = new Node(data);
//                newNode.next = temp.next;
                Node newNode = new Node(data, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
}
