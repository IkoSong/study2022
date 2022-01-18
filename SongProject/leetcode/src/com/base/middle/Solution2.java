package com.base.middle;

import com.base.common.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result = new ListNode(0);
//        ListNode temp = result;
//        int carry = 0;
//        while(l1!=null || l2!=null){
//            int val1 = l1!=null?l1.val:0;
//            int val2 = l2!=null?l2.val:0;
//            int sum = val1 + val2 + carry;
//            carry = sum/10;
//            temp.next = new ListNode(sum%10);
//            temp = temp.next;
//            if(l1!=null){
//                l1 = l1.next;
//            }
//            if(l2 != null){
//                l2 = l2.next;
//            }
//        }
//        if(carry != 0){
//            temp.next = new ListNode(carry);
//        }
//        return result.next;
//    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,0);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int val1 = l1 != null ? l1.val : 0;
        int val2 = l2 != null ? l2.val : 0;
        int sum = val1 + val2 + carry;
        int val = sum % 10;
        carry = sum / 10;
        ListNode result = new ListNode(val, addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry));
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(4, new ListNode(9))));
        ListNode l2 = new ListNode(1, new ListNode(6, new ListNode(7)));
        System.out.println(addTwoNumbers(l1, l2).listNodeToString());
    }
}
