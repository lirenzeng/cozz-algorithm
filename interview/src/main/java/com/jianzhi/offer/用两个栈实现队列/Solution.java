package com.jianzhi.offer.用两个栈实现队列;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 */
public class Solution {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(Integer a) {
        in.push(a);
    }

    public Integer pop() {
        if (in.isEmpty() && out.isEmpty()) {
            return -1;
        }
        if (!out.isEmpty()) {
            return out.pop();
        }
        while (!in.isEmpty()) {
            out.push(in.pop());
        }

        if (!out.isEmpty()) {
            return out.pop();
        }
        return -1;

    }

    public static void main(String[] args) {

        Solution s = new Solution();
        s.push(3);
        s.push(4);

        System.out.println(s.pop());

        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());


    }

}
