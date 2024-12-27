package com.feature.ds;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArraysChallenges {
    public static void main(String[] args) {
        // System.out.println(minMaxGame(new int[]{70,38,21,22}));
        // System.out.println(strStr("mississippi", "issip"));
        // System.out.println(reverse(Integer.MAX_VALUE));
        ///System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        // System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));

        //int[] digits = plusOne(new int[]{8,9,9,9});
        // System.out.println(Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        //String str1 = "Interviewbit".replace('e','s');
        //System.out.print(str1);

        //int[]  x = {120, 200, 011};
        //for(int i = 0; i < x.length; i++){
        //    System.out.print(x[i] + " ");
        // }

        //System.out.println(climbStairs(6));
        // System.out.println(isPalindrome("race a car"));

        //int[] digits = new int[]{8,9,9,9,10,11, 1};
        // System.out.println(majorityElement(digits));

        // System.out.println(convertToTitle(26));
        //System.out.println(convertToTitle(2147483647));
        //System.out.println(titleToNumber("FXSHRXW"));

        //Set<Integer> state = Arrays.stream(digits)
          //      .boxed().collect(Collectors.toSet());

        // System.out.println(countAndSay(5));
        // System.out.println(generateParenthesis(3));

        System.out.println(longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }

    public static String longestPalindrome(String s) {

        if ( s == null || s.equals("")) {
            return s;
        }

        Set<String> state = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            System.out.println("*" + str);
            if (isPalindrome(str)) {
                return str;
            } else if (!state.contains(str)) {
                queue.add(str.substring(0, str.length() - 1));
                queue.add(str.substring(1));
            }
            state.add(str);
        }

        return null;
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        // Compare characters while i < j
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static List<String> generateParenthesis(int n) {
        if ( n == 1)
            return Arrays.asList("()");

        List<String> result = generateParenthesis(--n);
        Set<String> state = new LinkedHashSet<>();

        result.stream().forEach(r -> {
            for (int i = 0; i < r.length(); i++) {
                state.add(new StringBuilder(r).insert(i, "()").toString());
            }
        });
        return state.stream().collect(Collectors.toList());

    }

    public static String countAndSay(int n) {

        if ( n == 1) return "1";
        if ( n == 2) return "11";

        String result = countAndSay(--n);
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length() -1; i++) {
            if (result.charAt(i) == result.charAt(i+1)) {
                count++;
            } else {
                stringBuilder.append(count).append(result.charAt(i));
                count = 1;
            }

            if ( i == result.length() -1- 1) {
                stringBuilder.append(count).append(result.charAt(i+1));
            }
        }
        return stringBuilder.toString();

    }

    public static int titleToNumber(String columnTitle) {

        int s = (columnTitle.charAt(0) - 'A') + 1;
        for (int i = 1; i < columnTitle.length(); i++) {
            s *=26;
            s += (columnTitle.charAt(i) - 'A') + 1;
        }

        return s;
    }

    public static  String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            result.append((char)('A' + columnNumber % 26));
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }

    public static int majorityElement(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .findFirst().get().getKey();
    }


    public static boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() == nums.length;
    }



    public static int climbStairs(int n) {
        if ( n == 1 || n == 2) return n;

        int v1 = 2;
        int v2 = 1;
        int res = 0;

        for ( int i=2; i < n; i++) {
            res = v1 + v2; // 3 / 5 / 8 // 13
            v2 = v1; // 3
            v1 = res; // 2
        }

        return res;
    }

    public static int[] plusOne(int[] digits) {

        int carry = 1;
        for (int i = digits.length -1; i >= 0 ; i--) {
            if ( digits[i] + carry <= 9)
                return digits;
            else {
                digits[i] = 0;
                carry = 1;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static int removeDuplicates(int[] nums) {

        int c = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[c]){
                nums[++c] = nums[i];
            }
        }

        System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        return c;

    }

}


