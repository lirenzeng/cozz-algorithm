package com.leetcode.numbers;

import java.util.HashMap;
import java.util.Map;

public class SumTwoNumber {

    public int[] solution(int[] nums, int target) {

        int length = nums.length;
        if (length < 2) {
            return null;
        }

        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                ret[0] = map.get(another);
                ret[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return ret;

    }

    public static void main(String[] args) {
        int[] a = {3,3};
        int[] b = new SumTwoNumber().solution(a, 6);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
