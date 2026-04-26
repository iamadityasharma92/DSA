class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<int[]> heap= new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] ans=new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){
            heap.offer(new int[]{nums[i],i});
            if(i>=k-1){
                //lazy removal from heap remove only if top element to be removed 
                while(heap.peek()[1]<=i-k){
                    heap.poll();
                }
                ans[idx++]=heap.peek()[0];
            }
        }
        return ans;
    }
}
