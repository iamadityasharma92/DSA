class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
            });
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
            q.offer(new int[]{i.getValue(),i.getKey()});
        }
        int idx=0;
        while(!q.isEmpty()){
            int[] ele=q.poll();
            for(int i=0;i<ele[0];i++){
                nums[idx++]=ele[1];
            }
        }
        return nums;

    }
}