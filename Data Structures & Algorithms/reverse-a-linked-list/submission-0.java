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

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
        return head;
        ListNode prev = new ListNode(-100);
        ListNode t=head;
        while(t!=null){
            ListNode tmp= t.next;
            t.next=prev;
            prev=t;
            t=tmp;
        }
        head.next=null;
        return prev;
    }
}
