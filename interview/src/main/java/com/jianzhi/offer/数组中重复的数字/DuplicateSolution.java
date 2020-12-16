package com.jianzhi.offer.数组中重复的数字;

public class DuplicateSolution {


    /**
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。
     * @param nums
     * @param lenght
     * @return
     */
    public static int duplicate(int[] nums, int lenght) {
        if (nums == null || lenght <= 0) {
            return -1;
        }

        for (int i = 0; i < lenght; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                swap(nums, i, nums[i]);
            }

        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

        int[] a = new int[]{2,3,1,0,2,4};

        System.out.println(duplicate(a, 5));


    }
}
