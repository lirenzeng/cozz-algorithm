package com.jianzhi.offer.第一个只出现一次的字符位置;

import java.util.BitSet;

public class Solution {


    /**
     * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
     * @param s
     * @return
     */
    public static int FirstNotRepeatingChar(String s) {
        int[] cnt = new int[128];
        for (int i = 0; i < s.toCharArray().length; i++) {
            cnt[s.toCharArray()[i]]++;
        }
        for (int j = 0; j < s.toCharArray().length; j++) {
            if (cnt[s.toCharArray()[j]] == 1) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 使用BitSet 优化空间复杂度
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar2(String str) {
        BitSet a = new BitSet(128);
        BitSet b = new BitSet(128);

        for (char c : str.toCharArray()) {
            if (!a.get(c) && !b.get(c)) {
                a.set(c);
            } else if (a.get(c) && !b.get(c)) {
                b.set(c);
            }
        }

        for (int i = 0; i < str.toCharArray().length; i++) {
            char c = str.charAt(i);
            if (a.get(c) && !b.get(c)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String a = "ababccd";

        System.out.println(FirstNotRepeatingChar2(a));

    }

}
