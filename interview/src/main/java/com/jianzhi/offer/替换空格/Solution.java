package com.jianzhi.offer.替换空格;

public class Solution {


    /**
     * 将一个字符串中的空格替换成 "%20"。
     */
    public static String replaceSpace(StringBuffer s) {

        int P1 = s.length() - 1;
        for (int i = 0; i <= P1; i++) {
            if (s.charAt(i) == ' ') {
                s.append("  ");
            }
        }
        int P2 = s.length() - 1;

        while (P1 >= 0 && P2 >= P1) {
            char c = s.charAt(P1--);
            if (c == ' ') {
                s.setCharAt(P2--, '0');
                s.setCharAt(P2--, '2');
                s.setCharAt(P2--, '%');

            } else {
                s.setCharAt(P2--, c);
            }

        }

        return s.toString();
    }

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("a b c");

        System.out.println(replaceSpace(sb));

    }

}
