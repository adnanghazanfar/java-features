package com.feature.dp;

import java.util.Arrays;

public class TribonacciSeries {

    public static void main(String[] args) {
        System.out.println("******* Tribonacci *******");
        long s = System.currentTimeMillis();
        int n = 35;
        printTrib(n);
        long l = System.currentTimeMillis();
        System.out.println("Time taken: " + (l-s));
    }

    private static void printTrib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(printTribRec(i, dp) +" ");
        }

        System.out.println();
    }

    private static int printTribRec(int i, int[] dp) {
        if (i == 0) return 0;
        else if (i == 1) return 1;
        else if (i == 2) return 1;

        //if (dp[i] != -1) return dp[i];
        return dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

}
