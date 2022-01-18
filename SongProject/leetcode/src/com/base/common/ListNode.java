package com.base.common;

/**
 * 链表对象
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String listNodeToString() {
        ListNode temp = this;
        if (temp == null) {
            return "[]";
        }
        String result = "";
        while (temp != null) {
            result += temp.val + ", ";
            temp = temp.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
}
