package Recursion;

import java.util.Scanner;

public class parameterizedAndFunctionalRecur {

    /**
     * parameterized method
     **/
    private static void printSum(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        printSum(i - 1, sum + i);
    }

    private static void printFactorial(int i, int fact) {
        if (i == 1) {
            System.out.println(fact);
            return;
        }
        printFactorial(i - 1, fact * i);
    }

    /**
     * Functional method
     **/
    private static int printsumFunctional(int num) {
        if (num == 0) return 0;
        return num + printsumFunctional(num - 1);
    }

    private static int printFactorialFunctional(int num) {
        if (num == 1) return 1;
        return num * printFactorialFunctional(num - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please provide the num to proceed: ");
        int num = sc.nextInt();

        printSum(num, 0);
        int finalSum = printsumFunctional(num);
        System.out.println("sum is : " + finalSum);

        printFactorial(num, 1);
        int finalFactorial = printFactorialFunctional(num);
        System.out.println("factorial is : " + finalFactorial);

    }
}
