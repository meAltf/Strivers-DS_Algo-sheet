package String;

import java.util.*;

public class StringBasics {

    private static void generateAllSubString(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.print(str.substring(i, j) + " "); //j is excluding
            }
        }
    }

    private static void checkPalindrome(String str) {
        StringBuilder gtr = new StringBuilder(str);
        gtr.reverse();
        String gtrUpdated = gtr + ""; // Hack to convert stringBuilder to string | just add an empty string

        if (str.equals(gtrUpdated)) System.out.println("Palindrome - Yes");
        else System.out.println("Palindrome - No");
    }

    private static void checkPalindrome2(String str) {
        int i = 0, j = str.length() - 1;
        boolean flag = true; // palindrome yes

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                flag = false;
                break;
            }
            i++;
            j--;
        }
        if (flag) System.out.println("Yes palindrome!");
        else System.out.println("Not palindrome!");
    }

    private static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private static int checkPalindromicSubStringCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (isPalindrome(str.substring(i, j))) {
                    count++;
                    System.out.print(str.substring(i, j) + " ");
                }
            }
        }
        return count;
    }

    private static String reverseWordInSentence(String str) {
        String ans = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                sb.append(ch);
            } else {                            // ch = ' ' | empty space
                sb.reverse();
                ans += sb;
                ans += " ";
                sb = new StringBuilder();       // sb = sb.delete(0, sb.length()-1);
            }
        }
        // for last word in this sentence
        System.out.println("Last word, needs to add from stringBuilder: " + sb);
        sb.reverse();
        ans += sb;
        return ans;
    }

    private static String compressedString(String str) {
        String ans = "" + str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);

            if (curr == prev) {
                count++;
            } else {
                if (count > 1) ans += count;
                count = 1;
                ans += curr;
            }
        }
        // for last element
        if (count > 1) ans += count;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide the string: ");
        String str = sc.nextLine();

        // generate all substrings
        generateAllSubString(str);

        // check palindrome | not best way
        checkPalindrome(str);

        // check palindrome | best way
        checkPalindrome2(str);

        // check total count of substring in a string
        int result = checkPalindromicSubStringCount(str);
        System.out.println("Count of total palindromic substring: " + result);

        //  reverse every word in a sentence without changing the order
        String updatedStr = reverseWordInSentence(str);
        System.out.println(updatedStr);

        // compressed string
        String compressedStr = compressedString(str);
        System.out.println("The compressed string: " + compressedStr);
    }
}
