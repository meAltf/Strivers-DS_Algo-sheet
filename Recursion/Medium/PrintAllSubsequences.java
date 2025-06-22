package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequences {

    private static void printAllSubsequences(int idx, List<Integer> ds, int[] arr, int n) {
        if (idx == n) {
            if (ds.isEmpty()) System.out.println("{}");
            for (int num : ds) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        // take or pick the particular index into the subsequence
        ds.add(arr[idx]);
        printAllSubsequences(idx + 1, ds, arr, n);

        ds.remove(ds.size() - 1); // ds.removeLast();

        // not pick, or not take condition, this element is not added to your subsequence
        printAllSubsequences(idx + 1, ds, arr, n);

    }

    private static void printAllsubsequencesSumEqualTok(int idx, List<Integer> ds, int sum, int k, int[] arr, int n) {
        if (idx == n) {
            if (sum == k) {
                for (int num : ds) System.out.print(num + " ");
                System.out.println();
            }
            return;
        }

        // take or pick the particular index into the subsequence | and add it into sum and once removed, minus from sum as well
        ds.add(arr[idx]);
        sum += arr[idx];
        printAllsubsequencesSumEqualTok(idx + 1, ds, sum, k, arr, n);
        sum -= arr[idx];
        ds.remove(ds.size() - 1);

        // not pick, or not take condition, this element is not added to your subsequence
        printAllsubsequencesSumEqualTok(idx + 1, ds, sum, k, arr, n);
    }

    private static boolean print1subsequencesSumEqualTok(int idx, List<Integer> ds, int sum, int k, int[] arr, int n) {
        if (idx == n) {
            if (sum == k) {
                for (int num : ds) System.out.print(num + " ");
                System.out.println();
                return true;
            } else return false;
        }

        // take or pick the particular index into the subsequence | and add it into sum and once removed, minus from sum as well
        ds.add(arr[idx]);
        sum += arr[idx];
        if (print1subsequencesSumEqualTok(idx + 1, ds, sum, k, arr, n) == true) {
            return true;
        }
        sum -= arr[idx];
        ds.remove(ds.size() - 1);

        // not pick, or not take condition, this element is not added to your subsequence
        if (print1subsequencesSumEqualTok(idx + 1, ds, sum, k, arr, n) == true) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int n = arr.length;
        int k = 2;
        List<Integer> dsList = new ArrayList<>();

        printAllSubsequences(0, dsList, arr, n);

        System.out.println("All subsequence having sum to equal to k : ");
        printAllsubsequencesSumEqualTok(0, dsList, 0, k, arr, n);

        System.out.println("print only 1 subsequence : ");
        print1subsequencesSumEqualTok(0, dsList, 0, k, arr, n);
    }
}
