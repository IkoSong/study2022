package slh.code.leetcode;

public class Revert {
    public static ListNode revertListNode(ListNode head){
       if(head==null){
           return null;
       }
       ListNode pre =null;
       ListNode cur = head;
       while(cur!=null){
           ListNode nex = cur.next;
           cur.next = pre;
           pre = cur;
           cur = nex;
       }
       return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,null)));

        ListNode result = revertListNode(head);
        ListNode.show(result);

    }


}
