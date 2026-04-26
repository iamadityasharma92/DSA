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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        //find mid
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //now separate 2nd half 
        ListNode second = slow.next;//start of 2nd half 
        ListNode prev=null;
        slow.next=null;//detach first list
        while(second!=null){
            ListNode tmp = second.next;
            second.next=prev;
            prev=second;
            second=tmp;
        }
        // now prev contains head of second LL after reversing
        // now start merging lists
        ListNode l1=head;// storing head in temp
        ListNode l2=prev;// head of 2nd list
        while(l2!=null){
            ListNode tmp1=l1.next;
            ListNode tmp2=l2.next;
            l1.next=l2;// add next limit to list from list2
            l2.next=tmp1; // list2 ka next list1 ke older next pr add krdenge          
            l1=tmp1;// now move current pointers of list
            l2=tmp2;
        }
    }
}
