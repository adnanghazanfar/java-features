package com.feature.dp;

import java.util.Arrays;

public class LIS {

    public static void main() {
        System.out.println((lengthOfLIS(new int[]{1,2,3,6,4,5,})));
        System.out.println((lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6})));
        System.out.println((lengthOfLIS(new int[]{10,9,2,5,3,7,101,18})));
    }

    private static int lengthOfLIS(int[] arr) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, lis(arr, i, dp));
        }
        return res;
    }

    private static int lis(int[] arr, int idx, int[] dp) {
        int max = 1;

        if ( dp[idx] != -1 )
            return dp[idx];

        for (int i = 0; i < idx; i++) {
            if ( arr[i] < arr[idx]) {
                max = Math.max(max, lis(arr, i, dp) + 1);
            }
        }
        dp[idx] = max;

        return max;
    }


}
