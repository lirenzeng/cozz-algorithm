package com.jianzhi.offer;

import java.util.Stack;

public class PrintListInverserly {

    public static class ListNode {
        int val;
        ListNode next;
    }

    public static void printListInverselyUsingInteration(ListNode root) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }

        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.val + " ");
        }
    }

    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.next);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.next = new ListNode();
        root.next.val = 2;
        root.next.next = new ListNode();
        root.next.next.val = 3;
        root.next.next.next = new ListNode();
        root.next.next.next.val = 4;
        root.next.next.next.next = new ListNode();
        root.next.next.next.next.val = 5;

        printListInverselyUsingInteration(root);
        System.out.println();
        printListInverselyUsingRecursion(root);
    }
}
