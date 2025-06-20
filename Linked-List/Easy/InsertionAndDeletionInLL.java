package LinkedListLearn;

public class InsetionAndDeletionInLL {

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

    private static void printLL(Node head) {
        if (head == null) return;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static Node removesHead(Node head) {
        if (head == null) return head;
        head = head.next;
        return head;
    }

    private static Node removesTail(Node head) {
        if (head == null || head.next == null) return head;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 35};
        Node head = convertArr2LinkedList(arr);

        // delete the head of ll
        printLL(head);
        Node updatedHead = removesHead(head);
        printLL(updatedHead);

        // remove tail of ll
        Node updatedHead2 = removesTail(head);
        printLL(updatedHead2);
    }
}
