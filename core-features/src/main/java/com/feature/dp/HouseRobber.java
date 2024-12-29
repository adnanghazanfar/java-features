package com.feature.dp;

public class HouseRobber {

    public static void main(String[] args) {
        int[] hval = {6, 7, 1, 3, 8, 2, 4,5,3,6,3,2,1,3,5,2,6,2,5,25,5,2,4,22,23,22,42,2,23,5,2,32,43,23};
        
        System.out.println("******* Tabulation *******");
        long s = System.currentTimeMillis();
        System.out.println(maxLoot(hval));
        long l = System.currentTimeMillis();
        System.out.println("Time taken: " + (l-s));


        System.out.println("******* Recursion *******");
        long s2 = System.currentTimeMillis();
        System.out.println(maxLootRecursion(hval, hval.length));
        long l2 = System.currentTimeMillis();
        System.out.println("Time taken: " + (l2-s2));
    }

    private static int maxLoot(int[] hval) {

        if ( hval.length == 1) return hval[0];
        else if ( hval.length == 2) return Math.max(hval[0], hval[1]);

        int[] dp = new int[hval.length + 1];
        dp[0] = hval[0];
        dp[1] = hval[1];
        dp[2] = hval[2] + hval[0];

        int max = 0;
        for (int i = 3; i < hval.length; i++) {
            dp[i] = hval[i] + Math.max(dp[i-2], dp[i-3]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static int maxLootRecursion(int[] hval, int index) {
        if (index <= 0) return 0;
        else if (index == 1) return hval[0];
        return Math.max(hval[index-1] + maxLootRecursion(hval, index-2), maxLootRecursion(hval, index-1));
    }
}
