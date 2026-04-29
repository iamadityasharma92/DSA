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
        Map<Node,Node> map=new HashMap<>();
        //copy null null also 
        map.put(null,null);
        // check if element present in map then fine if not then add new node 
        while(current !=null){
            if(!map.containsKey(current)){
                map.put(current,new Node(0));
            }
            map.get(current).val=current.val;
            if(!map.containsKey(current.next)){
                map.put(current.next,new Node(0));
            }
            // jo current add krri thi uska next
            map.get(current).next=map.get(current.next);
            if(!map.containsKey(current.random)){
                map.put(current.random,new Node(0));
            }
            map.get(current).random=map.get(current.random);
            current=current.next;
            
        }
        
        return map.get(head);
    }
}