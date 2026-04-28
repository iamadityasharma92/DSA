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

        ListNode pre=dummy;// start from one position back (in case if l=1 and we need to reverse from first position)
        for(int i=1;i<l;i++){
            pre=pre.next;
        }
        // store previous node for chaining after reversing
        ListNode prevNode=pre.next;// prevNode have 3 so that we can connect last valli list with this 
        ListNode prev=null;// previous empty node for reversing
        // for iterating and reversing
        ListNode current= pre.next;
        for(int i=1;i<=r-l+1;i++){
            ListNode tmp =current.next;
            current.next =prev;
            prev=current;
            current=tmp;
        }
        // System.out.println("current->"+current.val+" prev ->"+prev.val+" prevNode->"+prevNode.val+" pre->"+pre.val);
        // pre have node of first part from where we broke or start reversing list  head = [1,2,3,4,5,6], left = 3, right = 5, it stores 2
        pre.next=prev;// prev have head of reversed list 
        prevNode.next=current;// connecting last valli list with end of reversed list -> 3->6 = 1->2->5->4->'3->6'
        return dummy.next;

    }
}