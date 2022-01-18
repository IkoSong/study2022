package slh.code.leetcode;


/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照**逆序**的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution2 {
    //输入：l1 = [2,4,3], l2 = [5,6,4]
    //输出：[7,0,8]
    //解释：342 + 465 = 807.

    //输入：l1 = [0], l2 = [0]
    //输出：[0]

    //ListNode[2,next:[4,next[3,null]]];
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3,null)));
//        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4,null)));
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,null)));
        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,null)))));
        ListNode listNode = addTwoNumbers(l1, l2);
        ListNode.show(listNode);

    }

    public static ListNode addTwoNumbersMySolution(ListNode l1, ListNode l2) {
        //999999
        //9999
        //899900

        ListNode result = new ListNode(0);

        if(l1 != null || l2 != null){
            result.val = (l1== null?0:l1.val) + (l2 == null?0:l2.val);
            if(result.val>9){
                result.val = result.val%10;
                if(l1!=null){
                    if(l1.next!=null){
                        l1.next.val++;
                    }else{
                        l1.next = new ListNode(1);
                    }
                }else {
                    if(l2.next!=null){
                        l2.next.val++;
                    }else{
                        l2.next = new ListNode(1);
                    }
                }
            }
            result.next = addTwoNumbersMySolution(l1== null?null:l1.next,l2==null?null:l2.next);
        }else{
            result = null;
        }
        return result;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){




//返回头节点
//
//作者：edelweisskoko
        //先将l1和l2头节点的值加起来赋值给新链表的头节点
        ListNode result = new ListNode(l1.val+l2.val);
        ListNode cur = result;
        //遍历两个链表，只要有一个链表还没有遍历到末尾，就继续遍历
        while(l1.next!=null || l2.next!=null){
            l1 = l1.next!=null?l1.next:new ListNode();
            l2 = l2.next!=null?l2.next:new ListNode();
            //每次遍历生成一个当前节点cur的下一个节点，其值为两链表对应节点的和再加上当前节点cur产生的进位
            cur.next = new ListNode(l1.val + l2.val + cur.val/10);
            cur.val = cur.val%10;
            //更新进位后的当前节点cur的值
            cur = cur.next;

        }
        //循环结束后，因为首位可能产生进位，因此如果cur.val是两位数的话，新增一个节点
        if(cur.val>=10){
            cur.next = new ListNode(1);
            cur.val = cur.val%10;
        }
        return result;
    }

}

