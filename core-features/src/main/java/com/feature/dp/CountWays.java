package com.feature.dp;

import java.util.Arrays;

public class CountWays {

    public static void main(String[] args) {
        int n = 45;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = dp [1] = 1;
        System.out.println(countWays(n, dp));
    }

    private static int countWays(int n, int[] dp) {
        if (n == 0 || n == 1)
            return 1;

        if ( dp[n] != -1) return dp[n];
        return dp[n] = countWays(n-1, dp) + countWays(n-2, dp);
    }

}
