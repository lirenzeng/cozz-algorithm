package com.leetcode.tree;

public class MiniDepthBTree {

    /**
     * 树根节点和叶子节点的最小路径
     * @param node
     * @return
     */
    public int miniDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = miniDepth(node.left);
        int right = miniDepth(node.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }

        return Math.min(left, right) + 1;


    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n4;
        n2.right = n3;

        System.out.println(new MiniDepthBTree().miniDepth(n1));

    }

}
