package com.leetcode.tree;

public class DiameterBTree {

    private int max = 0;

    /**
     * 树的最长路径
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = depth(node.left);
        int r = depth(node.right);
        max = Math.max(max, l + r);
        return 1 + Math.max(l, r);
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
//        TreeNode t4 = new TreeNode(1);
//        TreeNode t5 = new TreeNode(1);
//        TreeNode t6 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;

//        t2.left = t3;
//        t2.right = t4;

        t3.left = t3.right = null;
        t2.left = t2.right = null;

//        t5.left = t6;
//        t5.right = null;
//
//        t6.right = t6.left = null;

        System.out.println(new DiameterBTree().diameterOfBinaryTree(t1));

    }
}
