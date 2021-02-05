package com.leetcode.linklist;

public class LinkNode {

    public LinkNode next;

    public int value;

    public LinkNode() {

    }

    public LinkNode(int value) {
        this.next = null;
        this.value = value;
    }
    public LinkNode(LinkNode next, int value) {
        this.next = next;
        this.value = value;
    }

}
