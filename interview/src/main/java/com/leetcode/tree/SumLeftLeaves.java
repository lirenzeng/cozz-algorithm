package com.leetcode.tree;

public class SumLeftLeaves {

    /**
     * 左子树叶子节点和
     * @param node
     * @return
     */
    public int sumLeftLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (isLeaf(node.left)) {
            return node.left.val + sumLeftLeaves(node.right);
        }

        return sumLeftLeaves(node.left) + sumLeftLeaves(node.right);
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }

        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        SumLeftLeaves s = new SumLeftLeaves();
        Utils.preVisitTree(n1);
        System.out.println(s.sumLeftLeaves(n1));
    }
}
