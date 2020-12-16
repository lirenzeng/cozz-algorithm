package com.leetcode.tree;

public class TreeMaxDepth {

    /**
     * 树的高度
     * @param root
     * @return
     */
    public static int getMaxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        t1.left = t2;
        t1.right = null;

        t2.left = t3;
        t2.right = t4;

        t3.left = t3.right = null;
        t4.left = t4.right = null;

        System.out.println(getMaxDepth(t1));
    }

}
