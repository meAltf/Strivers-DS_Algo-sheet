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

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        int n = arr.length;
        List<Integer> dsList = new ArrayList<>();

        printAllSubsequences(0, dsList, arr, n);
    }
}
