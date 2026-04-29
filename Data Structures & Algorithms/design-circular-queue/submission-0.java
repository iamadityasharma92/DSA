class MyCircularQueue {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next= null;
        }
    }
    int space;
    Node left;
    Node right;

    public MyCircularQueue(int k) {
        // for storing space left 
        this.space=k;
        this.left=new Node(0);// dummy node for starting
        this.right=this.left;
    }
    
    public boolean enQueue(int value) {
        if(isFull())return false;
        Node cur=new Node(value);
        if(isEmpty()){
            this.left.next=cur;
            this.right=cur;
        }else{
            this.right.next=cur;
            this.right=cur;
        }
        this.space--;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        this.left.next=this.left.next.next;
        // if last node hi agya then
        if(this.left.next==null){
            this.right=this.left;
        }
        this.space++;
        return true;
    }
    
    public int Front() {
        return isEmpty()?-1:this.left.next.val;
    }
    
    public int Rear() {
        return isEmpty()?-1:this.right.val;
    }
    
    public boolean isEmpty() {
        return this.left.next==null;
    }
    
    public boolean isFull() {
        return this.space==0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */