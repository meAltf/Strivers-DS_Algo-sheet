package LinkedListLearn;

class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class LinkedList {
    // 2,3,4,5
    private static Node convertArr2LinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static void traverseOnLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private static int lengthOfLL(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    private static int checkIfPresent(Node head, int num) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == num) return 1;
            temp = temp.next;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {92, 4, 6, 9};

        Node nodeNum = new Node(arr[3]);
        System.out.println(nodeNum.data);

        // convert an array into linkedList
        Node head = convertArr2LinkedList(arr);
        System.out.println(head.data);

        // traversing on linkedList
        traverseOnLL(head);

        // length of linkedList
        int length = lengthOfLL(head);
        System.out.println();
        System.out.println("length of ll: " + length);

        // check given num is present in ll or not
        int result = checkIfPresent(head, 9);
        System.out.println(result);
    }
}
