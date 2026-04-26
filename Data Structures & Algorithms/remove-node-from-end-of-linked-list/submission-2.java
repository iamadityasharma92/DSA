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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        ListNode second = head;
        for(int i=1;i<=n;i++){
            first=first.next;
        }
        if(first==null)// in this we need to simply return head it will handle single node case and also the case if first pointer reaches the end
        return head.next;// if first is null after it means you need to delete nth element from end i.e. the head of list
        while(first.next!=null){
            second=second.next;
            first=first.next;
        }
        second.next=second.next.next;
        return head;
    }
}
