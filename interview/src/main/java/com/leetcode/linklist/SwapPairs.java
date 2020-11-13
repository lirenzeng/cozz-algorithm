package com.leetcode.linklist;

public class SwapPairs {

    /**
     * 链表成对交换
     * @param head
     * @return
     */
    public static LinkNode swapPairs(LinkNode head) {
        LinkNode node = new LinkNode();
        node.next = head;
        LinkNode pre = node;

        while (pre.next != null && pre.next.next != null) {
            LinkNode l1 = pre.next, l2 = pre.next.next;
            LinkNode next = l2.next;

            l1.next = next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
        }

        return node.next;
    }

    public static void main(String[] args) {

        LinkNode a1 = new LinkNode();
        LinkNode a2 = new LinkNode();
        LinkNode a3 = new LinkNode();
        LinkNode a4 = new LinkNode();

        a1.value = 1;
        a1.next = a2;
        a2.value = 2;
        a2.next = a3;
        a3.value = 3;
        a3.next = a4;
        a4.value = 4;
        a4.next = null;

        LinkNode node = swapPairs(a1);
        LinkListReverse.printLinkList(node);
    }
}
