package com.leetcode.tree;

public class CheckBanlancedTree {

    private boolean result = true;

    /**
     * 是否是平衡树
     * @param root
     * @return
     */
    public boolean isBalancedTree(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = maxDepth(node.left);
        int r = maxDepth(node.right);

        if (Math.abs(l - r) > 1) {
            this.result = false;
        }

        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);

        t1.left = t2;
        t1.right = null;

        t2.left = t3;
        t2.right = null;

        t3.left = null;
        t3.right = t4;

        t4.left = t4.right = null;

        System.out.println(new CheckBanlancedTree().isBalancedTree(t1));

    }

}
