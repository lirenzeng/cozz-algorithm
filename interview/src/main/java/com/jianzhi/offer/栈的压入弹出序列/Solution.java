package com.jianzhi.offer.栈的压入弹出序列;


import java.util.Stack;

public class Solution {

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     *
     * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
     * @param in
     * @param out
     * @return
     */
    public static boolean isPopOrder(int[] in, int[] out) {
        if (in == null || out == null) {
            return false;
        }

        if (in.length <=0 || out.length <= 0) {
            return false;
        }

        int n = in.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(in[i]);
            while (j < n && !stack.isEmpty() && stack.peek() == out[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{4,3,5,1,2};

        System.out.println(isPopOrder(a, b));

    }

}
