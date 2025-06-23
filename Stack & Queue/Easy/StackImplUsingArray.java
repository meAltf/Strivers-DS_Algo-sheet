package StackAndQueue;

public class StackImpl {

    int top = -1;
    int[] stackArray = new int[10];

    /**
     * 10 20 30
     **/

    public void push(int num) {
        if (top == stackArray.length - 1) {
            System.out.println("Stack overflow!");
            return;
        }
        top++;
        stackArray[top] = num;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stackArray[top];
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow!");
            return -1;
        }
        int popElement = stackArray[top];
        top--;
        return popElement;
    }

    public int size() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("StackArray LIFO order");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.printStack();

        System.out.println("Peek element of Stack " + stack.peek());

        int poppedElement = stack.pop();
        System.out.println("Pop element " + poppedElement);
        stack.printStack();

        int stackSize = stack.size();
        System.out.println("Size of stack " + stackSize);
    }

}
