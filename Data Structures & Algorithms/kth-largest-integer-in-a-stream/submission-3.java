class KthLargest {
    PriorityQueue<Integer> q;
    int k;
    public KthLargest(int k, int[] nums) {
        q=new PriorityQueue<>();
        this.k=k;
        for(int i:nums){
            q.add(i);
            if(q.size()>k){
                q.poll();
            }
        }
    }
    
    public int add(int val) {
        q.add(val);
        if(q.size()>k){
            q.poll();
        }
        return q.peek();
    }
}
