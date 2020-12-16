package com.jianzhi.offer.包含min函数的栈;

import java.util.Stack;

/**
 * 实现一个包含 min() 函数的栈，该方法返回当前栈中最小的值。
 */
public class Solution {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> miniStack = new Stack<>();

    public void push(Integer a) {
        dataStack.push(a);
        miniStack.push(miniStack.isEmpty() ? a : Math.min(miniStack.peek(), a));
    }

    public void pop() {
        dataStack.pop();
        miniStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int mini() {
        return miniStack.peek();
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.push(5);
        solution.push(7);
        solution.push(1);

        System.out.println(solution.mini());
        solution.pop();
        System.out.println(solution.mini());
        solution.pop();
        System.out.println(solution.mini());

    }

}
