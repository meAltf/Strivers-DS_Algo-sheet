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
    }
}
