package Recursion;

import java.util.Scanner;

public class CheckStringPalindrome {

    private static boolean checkPalindromeRecursive(String str, int i) {
        int n = str.length();
        if (i >= n / 2) return true;

        if (str.charAt(i) != str.charAt(n - i - 1)) return false;
        return checkPalindromeRecursive(str, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide a string to proceed: ");
        String str = sc.nextLine();

        boolean result = checkPalindromeRecursive(str, 0);
        System.out.println(result);
    }
}
