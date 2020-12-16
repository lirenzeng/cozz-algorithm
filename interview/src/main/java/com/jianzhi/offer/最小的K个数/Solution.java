package com.jianzhi.offer.最小的K个数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 维护一个大小为 K 的最小堆过程如下：使用大顶堆。在添加一个元素之后，如果大顶堆的大小大于 K，那么将大顶堆的堆顶元素去除，也就是将当前堆中值最大的元素去除，从而使得留在堆中的元素都比被去除的元素来得小。
 *
 * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
 *
 * Java 的 PriorityQueue 实现了堆的能力，PriorityQueue 默认是小顶堆，可以在在初始化时使用 Lambda 表达式 (o1, o2) -> o2 - o1 来实现大顶堆。其它语言也有类似的堆数据结构。
 */
public class Solution {

    public static List<Integer> getLeastNumbers(int[] nums, int k) {

        if (k > nums.length || k <= 0) {
            return Collections.emptyList();
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);

    }

    public static List<Integer> getLeastNumbers2(int[] numbs, int k) {
        List<Integer> ret = new ArrayList<>();
        if (k > numbs.length || k <= 0) {
            return ret;
        }

        findKthSmallest(numbs, k);

        for (int i =0; i < k; i++) {
            ret.add(numbs[i]);
        }

        return ret;
    }

    private static void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            }
            if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }

        }
    }

    private static int partition(int[] nums, int l, int h) {
        int p = nums[l];
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p);
            while (j != l && nums[--j] > p);
            if (i >= j)
                break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return j;
    }


    public static void main(String[] args) {

        int[] a = new int[]{1,2,3,4,5,6,7,8};

        List<Integer> b = getLeastNumbers2(a, 4);
        for (int n : b) {
            System.out.println(n);
        }

    }

}
