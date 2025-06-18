package String;
import java.util.*;

/**
 * Important constructors of StringBuilder Class
 * 1. StringBuilder
 * 2. StringBuilder(String str) -> maximum going to use this
 * 3. StringBuilder(int capacity)
 */
public class StringBuilderLearn {

    // Approach 1. | using String
    private static String toggleStrByString(String str){
        // It's in uppercase | A-65, a-97, 0-48 | difference b/w uppercase & lowercase - [32]
        int n = str.length();
        for(int i=0; i<n; i++){
            boolean flag = true;
            char ch = str.charAt(i);
            if(ch == ' ') continue;  // skip, if found space
            int ascii = (int)ch;
            if(ascii >= 97) flag = false;

            if(flag){
                ascii += 32;
                char dh = (char)ascii;
                str = str.substring(0,i) + dh + str.substring(i+1);
            } else {
                ascii -= 32;
                char dh = (char)ascii;
                str = str.substring(0,i) + dh + str.substring(i+1);
            }
        }
        return str;
    }

    // Approach -2 | using stringBuilder
    private static void toggleStringByStringBuilder() {
        Scanner sc = new Scanner(System.in);
        StringBuilder strToggle = new StringBuilder(sc.nextLine());
        System.out.println("Here is the string : " + strToggle);

        for(int i=0; i<strToggle.length(); i++){
            boolean flag = true; // Uppercase currently
            char ch = strToggle.charAt(i);
            if(ch == ' ') continue;; // skip if it's space
            int ascii = (int)ch;
            if(ascii >= 97) flag = false; // lowercase currently

            if(flag){
                ascii += 32;
                char dh = (char)ascii;
                strToggle.setCharAt(i,dh);
            } else {
                ascii -= 32;
                char dh = (char)ascii;
                strToggle.setCharAt(i, dh);
            }
        }
        System.out.println("Updated string : " + strToggle);
    }

    public static void main(String[] args) {

        StringBuilder str = new StringBuilder("Robert");
        str.append("-broon");

        str.setCharAt(6,'-'); // It will replace that index with new value.

        StringBuilder str2 = new StringBuilder("Hello");
        str2.insert(5,'y'); // // It will insert at that index instead of replace.

        StringBuilder str3 = new StringBuilder("broon");
        str3.reverse();

        System.out.println(str3);

        /** Taking input as stringBuilder and solve the problem **/
        // Approach 2. | using StringBuilder
        toggleStringByStringBuilder();

        // change string to stringBuilder and use same way
        // StringBuilder str = new StringBuilder(inputString);

        String result = toggleStrByString("aLaTaF");
        System.out.println("updated string by string: " + result);

    }
}
