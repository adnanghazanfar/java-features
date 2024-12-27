package com.feature.dp;

import java.util.Arrays;

public class FibonacciSeries {

    public static void main(String[] args) {
        int n = 45;
        System.out.println("******* Tabulation *******");
        long s = System.currentTimeMillis();
        System.out.println(fibonacci(n));
        long l = System.currentTimeMillis();
        System.out.println("Time taken: " + (l-s));


        System.out.println("******* Memoization *******");
        long s2 = System.currentTimeMillis();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(fibonacci(n, dp));
        long l2 = System.currentTimeMillis();
        System.out.println("Time taken: " + (l2-s2));
        Arrays.stream(dp).forEach(v -> System.out.print(v + " "));
    }

    // Tabulation
    private static int fibonacci(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    // Memoization.
    private static int fibonacci(int n, int[] dp) {
        if ( n <= 1 ) return n;

        // To check if output already exists
        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fibonacci( n-2, dp) + fibonacci(n-1, dp);
    }

}
