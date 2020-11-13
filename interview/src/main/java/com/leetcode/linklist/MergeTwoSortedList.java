package com.leetcode.linklist;

public class MergeTwoSortedList {

    public static LinkNode solution(LinkNode a, LinkNode b) {

        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        if (a.value < b.value) {
            a.next = solution(a.next, b);
            return a;
        } else {
            b.next = solution(a, b.next);
            return b;
        }
    }

    public static void main(String[] args) {

        LinkNode a1 = new LinkNode();
        LinkNode a2 = new LinkNode();
        LinkNode a3 = new LinkNode();
        LinkNode a4 = new LinkNode();

        LinkNode c1 = new LinkNode();
        LinkNode c2 = new LinkNode();

        a1.value = 1;
        a1.next = a2;
        a2.value = 3;
        a2.next = a3;
        a3.value = 5;
        a3.next = a4;
        a4.value = 7;
        a4.next = null;
        c1.value = 2;
        c1.next = c2;
        c2.value = 6;
        c2.next = null;

        LinkNode node = solution(a1, c1);

        LinkListReverse.printLinkList(node);


    }

}
