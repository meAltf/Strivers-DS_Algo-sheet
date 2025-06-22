package Recursion;

import java.util.Scanner;

public class LearnMultipleRecursionCalls {

    private static void printNthFibonacciIterative(int num) {
        int a = 0, b = 1;
        System.out.print(a + " " + b);

        for (int i = 1; i < num; i++) {
            int next = a + b;
            System.out.print(" " + next);
            a = b;
            b = next;
        }
        System.out.println();
    }

    private static int NthFibonacciRecursive(int num) {
        if (num <= 1) return num;
        int last = NthFibonacciRecursive(num - 1);
        int secLast = NthFibonacciRecursive(num - 2);
        return last + secLast;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("please provide a numver to proceed: ");
        int num = sc.nextInt();
        printNthFibonacciIterative(num);

        System.out.println();

        int result = NthFibonacciRecursive(4);
        System.out.println(result);
    }
}
