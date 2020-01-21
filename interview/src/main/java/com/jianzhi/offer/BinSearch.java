package com.jianzhi.offer;

/**
 * 二分查找
 */
public class BinSearch {

    /**
     * 循环实现
     * @param key
     * @param array
     * @return
     */
    public static int binarySearch1(int key, int[] array) {

        int low = 0;
        int hight = array.length - 1;
        int middle = 0;
        if (key < array[low] || key > array[hight] || low > hight) {
            return -1;
        }

        while (low <= hight) {
            middle = (low + hight) / 2;
            if (array[middle] == key) {
                return array[middle];
            } else if (array[middle] < key) {
                low = middle + 1;
            } else {
                hight = middle - 1;
            }
        }

        return -1;
    }

    /**
     * 递归二分
     * @param key
     * @param array
     * @return
     */
    public static int binSearch2(int key, int[] array, int low, int high) {
        if (key < array[low] || key > array[high] || low > high) {
            return -1;
        }

        int middle = (low + high) / 2;
        if (array[middle] > key) {
            return binSearch2(key, array, low, middle - 1);
        } else if (array[middle] < key) {
            return binSearch2(key, array, middle+1, high);
        } else {
            return array[middle];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binSearch2(7, arr, 0, 9));
    }

}
