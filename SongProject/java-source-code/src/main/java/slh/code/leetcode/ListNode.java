package slh.code.leetcode;

public class ListNode {
    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }


    public static void show(ListNode head) {
        if (head == null) {
            System.out.println("EMPTY LIST!");
            return;
        }
        ListNode currNode = head;
        while (currNode.next != null) {
            System.out.print(currNode.val);
            System.out.print("->");
            currNode = currNode.next;
        }
        System.out.print(currNode.val);
        System.out.println();
    }

    public static ListNode reverse(ListNode head){
        ListNode result = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }

        return result;
    }

}
