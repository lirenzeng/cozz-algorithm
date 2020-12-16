package com.jianzhi.offer.数据流中的中位数;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Solution {

    private PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    private PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

    private int N = 0;

    public void insert(Integer val) {

        if (N % 2 == 0) {
            leftMaxHeap.add(val);
            rightMinHeap.add(leftMaxHeap.poll());
        } else {
            rightMinHeap.add(val);
            leftMaxHeap.add(rightMinHeap.poll());
        }
        N++;
    }

    public Double getMedian() {
        if (N % 2 == 0) {
            return (rightMinHeap.peek() + leftMaxHeap.peek()) / 2.0;
        } else {
            return (double) rightMinHeap.peek();
        }
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] a = new int[]{5,7,3,2,4,1,6};
        solution.insert(5);
        solution.insert(7);
        solution.insert(3);
        solution.insert(2);
        solution.insert(4);
        solution.insert(1);
        //solution.insert(6);
        System.out.println(solution.getMedian());

    }

}
