/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;
        Node res=new Node(-100);
        Map<Node,Node> map=new HashMap<>();
        // first make shallow copy and then we'll move for random pointer coz for random pointer we need nodes first 
        while(current !=null){
            Node copy=new Node(current.val);
            map.put(current,copy);
            current=current.next;
        }
        // now copy random pointer as we got shallow copy now 
        current=head;
        while(current!=null){
            Node copy= map.get(current);
            copy.next=map.get(current.next);
            copy.random=map.get(current.random);
            current=current.next;
        }
        return map.get(head);
    }
}
