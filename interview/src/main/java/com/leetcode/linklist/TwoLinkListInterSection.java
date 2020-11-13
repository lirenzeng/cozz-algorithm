package com.leetcode.linklist;

public class TwoLinkListInterSection {


    /**
     * 链表的交点
     * @param headA
     * @param headB
     * @return
     */
    private static LinkNode getIntersectionNode(LinkNode headA, LinkNode headB) {

        LinkNode l1 = headA, l2 = headB;
        while (l1 != l2) {

            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;

        }

        return l1;
    }

    /**
     * 两链表是否有交点
     * @param headA
     * @param headB
     * @return
     */
    public static boolean hasInterSectionNode(LinkNode headA, LinkNode headB) {
        LinkNode a = headA, b = headB;
        if (a == null || b == null) {
            return false;
        }
        while (a.next != null || b.next != null) {
            if (a.next != null) {
                a = a.next;
            }

            if (b.next != null) {
                b = b.next;
            }
        }

        if (a == b) {
            return true;
        }

        return false;

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

        LinkNode b1 = new LinkNode();
        LinkNode b2 = new LinkNode();
        LinkNode b3 = new LinkNode();

        b1.value = 3;
        b1.next = b2;
        b2.value = 5;
        b2.next = b3;
        b3.value = 14;
        b3.next = c1;

        LinkNode d1 = new LinkNode();
        LinkNode d2 = new LinkNode();
        d1.next = d2;
        d1.value = 5;
        d2.value = 6;
        d2.next = null;

        System.out.println(getIntersectionNode(a1, b1).value);

        System.out.println(hasInterSectionNode(d1, b1));



    }



}
