class KthLargest {
    PriorityQueue<Integer> q;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.q=new PriorityQueue<>();
        for(int i:nums){
            q.add(i);
        }
    }
    
    public int add(int val) {
        q.add(val);
        while(q.size()>k){
            q.poll();
        }
        return q.peek();
    }
}