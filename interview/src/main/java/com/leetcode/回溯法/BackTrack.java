package com.leetcode.回溯法;

import sun.jvm.hotspot.utilities.IntegerEnum;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法
 */
public class BackTrack {

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return res;
    }

    private void backTrack(int[] nums, LinkedList<Integer> track) {
        // 出发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i< nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }

            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backTrack(nums, track);
            // 撤回选择，重新回溯
            track.removeLast();
        }
    }

    public static void main(String[] args) {

        int[] a = new int[]{1,2,3,4};

        List<List<Integer>> b = new BackTrack().permute(a);

        for (List<Integer> c : b) {
            System.out.println(c);
        }

    }
}
