class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //PQ Method 
        Map<Integer,Integer> map= new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // make a PQ
        // first element will be key and other one will be value i.e. freq
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));//max heap
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            pq.add(new int[]{e.getKey(),e.getValue()});
        }
        int[] res=new int[k];
        while(k>0){
            res[--k]=pq.poll()[0];
        }
        return res;
    }
}
