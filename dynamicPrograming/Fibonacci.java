package dynamicPrograming;

import java.util.Arrays;

public class Fibonacci {
    public static int count = 0;
    public static int count2 = 0;
    public static int count3 = 0;

    // fibonacci using dp
    public static int fib(int n, int[] dp) {

        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        count++;
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);

        return dp[n];
    }

    // normal fibonacci
    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        count2++;
        return fib2(n - 1) + fib2(n - 2);
    }

    // tabulation
    public static int fib3(int n) {
        int prev = 0;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            count3++;
            int curr = prev + prev2;
            prev = prev2;
            prev2 = curr;
        }
        return prev2;
    }

    public static void main(String[] args) {
        int f = 35;
        int[] dp = new int[f + 1];
        Arrays.fill(dp, -1);

        System.out.println("1: Fib for " + f + " using dp is:--> " + fib(f, dp) + " --> fn count: " + count);
        System.out.println("3: Fib for " + f + " using tabulation is:--> " + fib3(f) + " --> fn count: " + count3);
        System.out.println("2: Fib for " + f + " using recursion is:--> " + fib2(f) + " --> fn count: " + count2);

    }
}
