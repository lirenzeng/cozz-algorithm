package com.leetcode.linklist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NoReapeatSubString {

    public int solution(String s) {
        if (s == null || s == "") {
            return 0;
        }

        char[] c = s.toCharArray();
        List<Character> cList = new ArrayList<>();
        int maxLen = 1;
        cList.add(c[0]);
        for (int i = 1; i < c.length; i++) {
            if (cList.contains(c[i])) {
                maxLen =  cList.size() > maxLen ? cList.size() : maxLen;
                int index = cList.indexOf(c[i]);
                Iterator iterator = cList.iterator();
                while (iterator.hasNext() && index >= 0) {
                    cList.remove(index);
                    index--;
                }
                cList.add(c[i]);
            } else {
                cList.add(c[i]);
            }
        }

        return maxLen > cList.size() ? maxLen : cList.size();

    }

    public int solution2(String s) {
        if (s == null || s == "" || s.isEmpty()) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int n = s.length();
        int rk = -1, ans = 0;

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i));
            }

            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }

            ans = Math.max(ans, rk - i + 1);
        }

        return ans;

    }

    public static void main(String[] args) {

        String a = "aaaaaa";
        System.out.println(new NoReapeatSubString().solution2(a));

    }
}
