package com.leetcode.tree;

public class HasPathNumber {


    /**
     * 判断树中是否存在一个路径的和与num相等
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathNum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }

        return hasPathNum(root.left, sum - root.val) || hasPathNum(root.right, sum - root.val);
    }
}
