class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key,int val){
            this.key=key;
            this.val=val;
            this.prev=null;
            this.next=null;
        }
    }

    int capacity;
    Map<Integer,Node> cache;
    Node left;
    Node right;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache= new HashMap<>();
        this.left=new Node(0,0);
        this.right=new Node(0,0);
        this.left.next=right;
        this.right.prev=left;
    }
    
    // we'll keep least recently used nodes to right and frequently used to left of DLL
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node= cache.get(key);
            remove(node);
            insertAfterHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
    if(cache.containsKey(key)){
        remove(cache.get(key));
    }
    Node node=new Node(key,value);
    cache.put(key,node);
    insertAfterHead(node);
    if(cache.size()>capacity){
        int k =this.right.prev.key;
        cache.remove(k);
        remove(this.right.prev);
    }
    }

    // Helper method for removing and adding values

    public void remove(Node node){
            Node nxt=node.next;
            Node prev=node.prev;
            node.prev.next=nxt;
            node.next.prev=prev;
        
    }
    
    public void insertAfterHead(Node node){
        Node nxt=this.left.next;
        node.next=nxt;
        node.prev=left;
        left.next=node;
        nxt.prev=node;
    }
}
