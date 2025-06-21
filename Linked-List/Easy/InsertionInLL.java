package LinkedListLearn;

public class InsertionInLL {

    private static Node convertArr2LL(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /** Insertion started from here **/

    private static Node insertionFromHead(Node head, int value){
        if(head == null) return null;

        return new Node(value, head);
    }

    private static Node insertionFromEnd(Node head, int data) {
        if (head == null) return head;

        Node newNode = new Node(data);
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    private static Node insertionFromHead2(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

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

    public static void main(String[] args) {
        int[] arr = {2,4,9,45,97};

        Node head = convertArr2LL(arr);
        printLL(head);
        System.out.println();

        // Insertion from head
        Node updatedNode1 = insertionFromHead(head, 111);
        printLL(updatedNode1);
        System.out.println();

        // Insertion from tails
        Node updatedNode2 = insertionFromEnd(head, 999);
        printLL(updatedNode2);
        System.out.println();

        // Insertion at given position
        Node updatedNode3 = insertioAtGivenNode(head, 786, 5);
        printLL(updatedNode3);
        System.out.println();
    }
}
