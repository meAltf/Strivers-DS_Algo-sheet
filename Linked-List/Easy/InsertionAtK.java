private static Node insertioAtGivenNode(Node head, int data, int k) {
        if (head == null) {
            if (k == 1) return new Node(data);
        }

        if (k == 1) {
//            Node newNode = new Node(data);
//            newNode.next = head;
//            return newNode;
            return new Node(data, head);
        }

        int count = 0;
        Node temp = head, prev = null;
        while (temp != null) {
            count++;
            if (k - 1 == count) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
