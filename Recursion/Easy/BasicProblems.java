package Recursion;

import java.util.Scanner;

public class BasicsRecur {

    private static void printNum(int num){
        if(num == 5) return;
        System.out.println(num);
        num++;
        printNum(num); // recursive call
    }

    private static void printName(int a, int b){
        if(a > b) return;
        System.out.println("robert!");
        printName(a+1, b);
    }

    private static void print1ToN(int a, int b){
        if(a > b) return;
        System.out.println(a);
        print1ToN(a+1, b);
    }

    private static void printNto1(int i, int n){
        if(i > n) return;
        System.out.println(n);
        //n--;
        printNto1(i, --n);
    }

    private static void printNto1Second(int i, int n){
        if(i<1) return;
        System.out.println(i);
        printNto1Second(i-1, n);
    }

    private static void print1toNBacktrack(int i, int n){
        if(i<1) return;
        print1toNBacktrack(i-1, n);
        System.out.println(i);
    }

    private static void printNto1Backtrack(int i, int n){
        if(i>n) return;
        printNto1Backtrack(i+1, n);
        System.out.println(i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide a number to proceed: ");
        int n = sc.nextInt();

        // printNum(0);
        // printName(1,4);
        // print1ToN(1,5);
        // printNto1(1, n);
        // printNto1Second(n,n);
        // print1toNBacktrack(n,n);
        printNto1Backtrack(1,n);
    }
}
