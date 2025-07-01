package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciNumber {

    // Fibonacci num: 0 1 1 2 3 5 8 13 21 34 55 89 ... so on
    private static int recursiveSol(int n) {
        if (n <= 1) return n;

        return recursiveSol(n - 1) + recursiveSol(n - 2);
    }

    // Memoization
    private static int memoizationSol(int n, int[] dp) {
        if (n <= 1) return n;

        if (dp[n] != -1) return dp[n];
        return memoizationSol(n - 1, dp) + memoizationSol(n - 2, dp);
    }

    // Tabulation
    private static int tabulationSol(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        if (dp[n] != -1) return dp[n];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // space optimized | intuitive solution
    private static int spaceOptimizedSol(int n) {
        if (n <= 1) return n;

        int curr, prev2 = 0, prev = 1;
        for (int i = 2; i <= n; i++) {
            curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide input to continue- ");
        int num = sc.nextInt();

        int result = recursiveSol(num);
        System.out.println("Recursive sol- " + result);

        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
        int resultM = tabulationSol(num, dp);
        System.out.println("tabulation sol- " + resultM);

        int resultOptimized = spaceOptimizedSol(num);
        System.out.println("intuive solution: " + resultOptimized);
    }
}
