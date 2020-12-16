package com.leetcode.tree;

public class MergeTwoBTree {

    /**
     * 合并二叉树
     * @param a
     * @param b
     * @return
     */
    public static TreeNode mergeTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        TreeNode newNode = new TreeNode(a.val + b.val);
        newNode.left = mergeTree(a.left , b.left);
        newNode.right = mergeTree(a.right, b.right);

        return newNode;
    }
}
