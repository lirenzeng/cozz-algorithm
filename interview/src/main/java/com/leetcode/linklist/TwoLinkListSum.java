package com.leetcode.linklist;

import java.util.Stack;

public class TwoLinkListSum {

    public static LinkNode addTwoLinkSum(LinkNode l1, LinkNode l2) {
        Stack<Integer> stack1 = pushNodeToStack(l1);
        Stack<Integer> stack2 = pushNodeToStack(l2);
        int carry = 0;
        LinkNode head = new LinkNode();

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {

            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();

            int sum = a + b + carry;
            LinkNode node = new LinkNode();
            node.value = sum % 10;

            carry = sum / 10;
            node.next = head.next;
            head.next = node;
        }

        return head.next;
    }

    public static Stack<Integer> pushNodeToStack(LinkNode head) {

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.value);
            head = head.next;
        }

        return stack;
    }

    public static void main(String[] args) {
        LinkNode a1 = new LinkNode();
        LinkNode a2 = new LinkNode();
        LinkNode a3 = new LinkNode();

        LinkNode b1 = new LinkNode();
        LinkNode b2 = new LinkNode();

        a1.value = 7;
        a1.next = a2;
        a2.value = 1;
        a2.next = a3;
        a3.value = 5;
        a3.next = null;

        b1.value = 6;
        b1.next = b2;
        b2.value = 8;
        b2.next = null;

        LinkNode node = addTwoLinkSum(a1, b1);

        LinkListReverse.printLinkList(node);
    }

}
