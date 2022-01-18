package com.base.easy;

import com.base.common.ListNode;

public class Solution206 {
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0, new ListNode(4, new ListNode(4, new ListNode(9))));
        System.out.println(reverseList(l1).listNodeToString());
    }
}
