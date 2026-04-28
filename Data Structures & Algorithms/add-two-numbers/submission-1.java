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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // use linked list approach if sum of nodes become >9 we'll take a carry forward 
        ListNode res = new ListNode(-100);
        ListNode temp=res;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){// single does not get missed at last
            // null pointers safety if any list exhaust
            int val1=l1!=null?l1.val:0;
            int val2=l2!=null?l2.val:0;
            // add carry 
            int sum = val1+val2+carry;
            carry=sum/10;// for taking carry forward to next digit
            temp.next=new ListNode(sum%10);// for not including carry in node while adding new node 
            temp=temp.next;
            // null pointers safety if any list exhaust
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        return res.next;

    }
}
