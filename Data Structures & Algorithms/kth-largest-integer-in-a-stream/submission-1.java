class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;// inorder to store size 
    public KthLargest(int k, int[] nums) {
        this.minHeap=new PriorityQueue<>(k);
        this.k=k;
        for(int num:nums){
            minHeap.add(num);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        // keep only k largest elements poll other smaller ones -> idea behind minHeap
        while(minHeap.size()>k){
            minHeap.poll();
        }
        //it will always return minimum of K largest elements -> that will eventually be the Kth largest element
        return minHeap.peek();
    }
}
