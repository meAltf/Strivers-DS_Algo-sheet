package DoublyLL;

class Node {
    int data;
    Node next;
    Node back;

    Node(int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}

public class DoubleLLBasics {

    private static void printDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private static Node convertArr2DLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node back = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, back);
            back.next = temp;
            back = temp;
        }
        return head;
    }

     private static Node deleteHeadOfDLL(Node head) {
        if (head == null || head.next == null) return null;

        Node prev = head;
        head = head.next;

        head.back = null;
        prev.next = null;

        return head;
    }

    public static void main(String[] args) {

        int[] arr = {2,5,7,9,11,17,21};

        Node head = convertArr2DLL(arr);
        printDLL(head);

         // Deletion of head in DLL
        Node updatedNode1 = deleteHeadOfDLL(head);
        printDLL(updatedNode1);
        System.out.println();

    }
}
