package com.leetcode.linklist;

public class LongLinkListSplitToParts {

    public static LinkNode[] splitListToParts(LinkNode root, int k) {

        int N = 0;
        LinkNode cur = root;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int mod = N % k;
        int size = N / k;

        LinkNode[] ret = new LinkNode[k];
        cur = root;
        for (int i = 0; cur != null && i < k; i++) {
            ret[i] = cur;
            int curSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }

            LinkNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        return ret;

    }

    public static void main(String[] args) {

        LinkNode a1 = new LinkNode();
        LinkNode a2 = new LinkNode();
        LinkNode a3 = new LinkNode();
        LinkNode a4 = new LinkNode();
        LinkNode a5 = new LinkNode();
        LinkNode a6 = new LinkNode();
        LinkNode a7 = new LinkNode();
        LinkNode a8 = new LinkNode();
        LinkNode a9 = new LinkNode();
        LinkNode a10 = new LinkNode();

        a1.value = 1;
        a1.next = a2;
        a2.value = 2;
        a2.next = a3;
        a3.value = 3;
        a3.next = a4;
        a4.value = 4;
        a4.next = a5;
        a5.value = 5;
        a5.next = a6;
        a6.value = 6;
        a6.next = a7;
        a7.value = 7;
        a7.next = a8;
        a8.value = 8;
        a8.next = a9;
        a9.value = 9;
        a9.next = a10;
        a10.value = 10;
        a10.next = null;

        LinkNode[] a = splitListToParts(a1, 7);

        for (LinkNode node : a) {
            LinkListReverse.printLinkList(node);
        }

    }

}
