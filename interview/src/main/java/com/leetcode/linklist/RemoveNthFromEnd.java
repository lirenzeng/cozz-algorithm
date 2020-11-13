package com.leetcode.linklist;

public class RemoveNthFromEnd {

    /**
     * 删除链表倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public static LinkNode removeNthFromEnd(LinkNode head, int n) {
        LinkNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }
        LinkNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
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

        LinkNode node = removeNthFromEnd(a1, 2);
        LinkListReverse.printLinkList(node);

    }
}
