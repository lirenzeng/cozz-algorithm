package com.leetcode.linklist;

public class DeleteDuplicateNode {

    /**
     * 删除链表中重复的node
     * @param head
     * @return
     */
    public static LinkNode solution(LinkNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        head.next = solution(head.next);
        return head.value == head.next.value ? head.next : head;
    }

    public static void main(String[] args) {

        LinkNode a1 = new LinkNode();
        LinkNode a2 = new LinkNode();
        LinkNode a3 = new LinkNode();
        LinkNode a4 = new LinkNode();
        LinkNode a5 = new LinkNode();

        a1.value = 1;
        a1.next = a2;
        a2.value = 2;
        a2.next = a3;
        a3.value = 2;
        a3.next = a4;
        a4.value = 3;
        a4.next = a5;
        a5.value = 4;
        a5.next = null;

        LinkNode node = solution(a1);

        LinkListReverse.printLinkList(node);
    }

}
