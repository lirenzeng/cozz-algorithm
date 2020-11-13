package com.leetcode.linklist;

public class OddEvenSeperate {

    public static LinkNode oddEvenList(LinkNode head) {

        if (head == null) {
            return head;
        }

        LinkNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {

            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;

        }
        odd.next = evenHead;
        return head;

    }

    public static void main(String[] args) {

        LinkNode a1 = new LinkNode();
        LinkNode a2 = new LinkNode();
        LinkNode a3 = new LinkNode();
        LinkNode a4 = new LinkNode();
        LinkNode a5 = new LinkNode();
        LinkNode a6 = new LinkNode();

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
        a6.next = null;

        LinkNode node = oddEvenList(a1);
        LinkListReverse.printLinkList(node);
    }

}
