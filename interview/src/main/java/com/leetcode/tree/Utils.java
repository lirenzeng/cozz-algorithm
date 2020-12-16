package com.leetcode.tree;

public class Utils {

    public static void preVisitTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preVisitTree(node.left);
        preVisitTree(node.right);
    }
}
