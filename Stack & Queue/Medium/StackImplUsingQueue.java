package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

class StackImplUsingQueue {
    Queue<Integer> stackUqueue = new LinkedList<>();

    public void push(int num) {
        stackUqueue.add(num);
        int size = stackUqueue.size();
        for (int i = 1; i < size; i++) {
            stackUqueue.add(stackUqueue.peek());
            stackUqueue.remove();
        }
    }

    public int pop() {
        if (stackUqueue.isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }
        return stackUqueue.remove(); // doesn't use peek() bcz you've to remove this element from stack.
    }

    public int top() {
        if (stackUqueue.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stackUqueue.peek();
    }

    public int size() {
        if (stackUqueue.isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }
        return stackUqueue.size();
    }

    public void printStack() {
        System.out.println("StackUsingQueue in LIFO order: " + stackUqueue);
    }

    public static void main(String[] args) {
        StackImplUsingQueue usingQueue = new StackImplUsingQueue();
        usingQueue.push(10);
        usingQueue.push(20);
        usingQueue.push(30);

        usingQueue.printStack();
        System.out.println("Top element: " + usingQueue.top());

        int poppedElement = usingQueue.pop();
        System.out.println("Popped element: " + poppedElement);

        usingQueue.printStack();
    }
}
