package com.leetcode.tree;

public class SubTree {


    /**
     * t是否是s的子树
     * @param s
     * @param t
     * @return
     */
    public boolean isSubTree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSubTreeWithRoot(s, t) || isSubTree(s.left, t) || isSubTree(s.right, t);
    }

    private boolean isSubTreeWithRoot(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (t == null || s == null) {
            return false;
        }
        if (t.val != s.val) {
            return false;
        }
        return isSubTreeWithRoot(s.left, t.left) && isSubTreeWithRoot(s.right, t.right);
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        TreeNode m1 = new TreeNode(4);
        TreeNode m2 = new TreeNode(1);
        TreeNode m3 = new TreeNode(2);

        n3.left = n4;
        n3.right = n5;
        n4.left = n1;
        n4.right = n2;

        m1.left = m2;
        m1.right = m3;

        System.out.println(new SubTree().isSubTree(n3, m1));

    }
}
