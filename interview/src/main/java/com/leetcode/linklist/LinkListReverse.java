package com.leetcode.linklist;

public class LinkListReverse {


    /**
     * 头插法
     * @param head
     * @return
     */
    public static LinkNode reverseListV1(LinkNode head) {

        LinkNode newHead = new LinkNode();
        while (head != null) {
            LinkNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }

        return newHead.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public static LinkNode reverseListV2(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkNode next = head.next;
        LinkNode newNode = reverseListV2(next);
        next.next = head;
        head.next = null;
        return newNode;
    }

    public static void printLinkList(LinkNode head) {
        while (head != null) {
            System.out.print(head.value);
            System.out.print("  ");
            head = head.next;
        }
        System.out.println();
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
        a2.value = 2;
        a2.next = a3;
        a3.value = 4;
        a3.next = a4;
        a4.value = 5;
        a4.next = c1;
        c1.value = 10;
        c1.next = c2;
        c2.value = 12;
        c2.next = null;

        printLinkList(a1);

        LinkNode newA = reverseListV2(a1);

        printLinkList(newA);
    }

}
