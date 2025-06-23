package StackAndQueue;

public class QueueImpl {

    int size = 10, currSize = 0;
    int[] queueArray = new int[size];
    int start = -1, end = -1;

    public void push(int num) {
        if (currSize == size) {
            System.out.println("Queue overFlow!");
            return;
        }
        if (currSize == 0) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % size;
        }
        queueArray[end] = num;
        currSize += 1;
    }

    public int pop() {
        if (currSize == 0) {
            System.out.println("Queue underFlow!");
            return -1;
        }
        int poppeddElement = queueArray[start];
        if (currSize == 1) {
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % size;
        }
        currSize -= 1;
        return poppeddElement;
    }

    public int peek() {
        if (currSize == 0) {
            System.out.println("Queue underFlow!");
            return -1;
        }
        return queueArray[start];
    }

    public int size() {
        return currSize;
    }

    public boolean isEmpty() {
        return currSize == -1;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Queue printing in FIFO order");
        for (int i = 0; i < currSize; i++) {
            int index = (start + i) % queueArray.length;
            System.out.print(queueArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        QueueImpl queueImpl = new QueueImpl();
        queueImpl.push(10);
        queueImpl.push(20);
        queueImpl.push(30);

        queueImpl.printQueue();
        int peekElement = queueImpl.peek();
        System.out.println("Peek element: " + peekElement);

        int poppedElement = queueImpl.pop();
        System.out.println("Popped element: " + poppedElement);

        System.out.println("current size of queue: " + queueImpl.currSize);

        queueImpl.printQueue();
    }
}
