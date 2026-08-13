class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
            q.offer(new int[]{i.getValue(),i.getKey()});
            if(q.size()>k){
                q.poll();
            }
        }
        int[] res=new int[k];
        int idx=0;
        while(!q.isEmpty()){
            res[idx++]=q.poll()[1];
        }
        return res;
    }
}