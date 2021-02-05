package com.leetcode.linklist;

/**
 * 链表的快速排序
 */
public class LinkedListQuickSort {

    public void quickSort(LinkNode head) {
        if (head == null || head.next == null) {
            return;
        }
        quickSort(head, null);
    }

    private void quickSort(LinkNode begin, LinkNode end) {
        if (begin != end && begin.next != end) {
            LinkNode p = partition(begin, end);
            quickSort(begin, p);
            quickSort(p.next, end);
        }
    }


    private LinkNode partition(LinkNode begin, LinkNode end) {
        int baseVal = begin.value;
        LinkNode base = begin;
        LinkNode cur = begin.next;
        while (cur != end) {
            if (cur.value < baseVal) {
                base = base.next;
                swap(base, cur);
            }

            cur = cur.next;
        }

        swap(base, begin);
        return base;
    }

    private void swap(LinkNode n1, LinkNode n2) {
        int tmp = n1.value;
        n1.value = n2.value;
        n2.value = tmp;
    }

    private void printSingleList(LinkNode head)
    {
        while(head != null)
        {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void main(String[] args) {

        LinkNode head = new LinkNode(4);
        LinkNode node1 = new LinkNode(2);
        LinkNode node2 = new LinkNode(5);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(7);
        LinkNode node5 = new LinkNode(9);
        LinkNode node6 = new LinkNode(0);
        LinkNode node7 = new LinkNode(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        LinkedListQuickSort sort = new LinkedListQuickSort();
        System.out.println("Befor quick sort:");
        sort.printSingleList(head);
        System.out.println("After quick sort: ");
        sort.quickSort(head);
        sort.printSingleList(head);



    }
}
