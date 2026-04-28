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
    public ListNode reverseBetween(ListNode head, int l, int r) {
        if(head==null || l==r) return head;
        ListNode dummy=new ListNode(-100);
        dummy.next=head;

        ListNode pre=dummy;
        for(int i=1;i<l;i++){
            pre=pre.next;
        }
        ListNode prevNode=pre.next;
        ListNode prev=null;
        ListNode current= pre.next;
        for(int i=1;i<=r-l+1;i++){
            ListNode tmp =current.next;
            current.next =prev;
            prev=current;
            current=tmp;
        }
        pre.next=prev;
        prevNode.next=current;
        return dummy.next;

    }
}