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

    public static void main(String[] args) {
        int[] arr = {2,4,9,45,97};

        Node head = convertArr2LL(arr);
        printLL(head);
        System.out.println();

        // Insertion from head
        Node updatedNode1 = insertionFromHead(head, 111);
        printLL(updatedNode1);
    }
}
