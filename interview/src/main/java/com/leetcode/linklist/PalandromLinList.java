package com.leetcode.linklist;

public class PalandromLinList {

    /**
     * 链表是否是回文链表
     * 1、快慢指针找到中间位置和末尾
     * 2、切出两个链表
     * 3、第二个链表reverse
     * 4、第一第二链表从头开始比对是否一致
     * @param head
     * @return
     */
    public static boolean checkPalandrom(LinkNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        LinkNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) { // 偶数个节点 slow指向下一个节点
            slow = slow.next;
        }
        cut(head, slow);

        return isEqual(head, reverse(slow));

    }

    private static void cut(LinkNode head, LinkNode cutNode) {
        if (head.next != cutNode) {
            head = head.next;
        }

        head.next = null;
    }

    private static LinkNode reverse(LinkNode head) {
        LinkNode newHead = null;
        while (head != null) {
            LinkNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    private static boolean isEqual(LinkNode a, LinkNode b) {

        while (a != null && b != null) {
            if (a.value != b.value) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkNode a1 = new LinkNode();
        LinkNode a2 = new LinkNode();
        LinkNode a3 = new LinkNode();
        LinkNode a4 = new LinkNode();
        LinkNode a5 = new LinkNode();
        LinkNode a6 = new LinkNode();
        LinkNode a7 = new LinkNode();

        a1.value = 1;
        a1.next = a2;
        a2.value = 1;
        a2.next = null;
        a3.value = 3;
        a3.next = a4;
        a4.value = 4;
        a4.next = a5;
        a5.value = 3;
        a5.next = a6;
        a6.value = 2;
        a6.next = null;
        a7.value = 2;
        a7.next = null;

        System.out.println(checkPalandrom(a1));



    }
}
