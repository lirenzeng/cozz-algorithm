package com.leetcode.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibnacheDemo {

    /**
     * 状态转移方程  暴力解法
     * @param N
     * @return
     */
    public static int fib1(int N)  {
        if (N == 1 || N == 2) {
            return 1;
        }

        return fib1(N - 1) + fib1(N - 2);
    }

    /**
     * 备忘录
     * @param N
     * @return
     */
    public static int fib2(int N) {
        if (N < 1) {
            return 0;
        }
        Integer[] memo = new Integer[N + 1];
        Arrays.fill(memo, 0);
        List memoList = Arrays.asList(memo);
        return helper(memoList, N);
    }

    /**
     * 备忘录
     * @param memo
     * @param n
     * @return
     */
    private static int helper(List<Integer> memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (memo.get(n) != 0) {
            return memo.get(n);
        }
        memo.set(n, helper(memo, n -1)  + helper(memo, n - 2));
        return memo.get(n);
    }


    /**
     * DP table
     * @param N
     * @return
     */
    public static int fib3(int N) {
        if (N < 1) {
            return 0;
        }
        int[] dp = new int[N + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i -1] + dp[i -2];
        }
        return dp[N];

    }

    /**
     * 空间复杂度优化
     * @param N
     * @return
     */
    public static int fib4(int N) {
        if (N == 2|| N == 1) {
            return 1;
        }

        int prv = 1, curr = 1;
        for (int i = 3; i <= N; i++) {
            int sum = prv + curr;
            prv = curr;
            curr = sum;
        }

        return curr;
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(fib4(50));
        System.out.println(System.currentTimeMillis() - time);

    }

}
