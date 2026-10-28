class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n= nums.length;
        if(k==1&&n==1) return nums;
        Map<Integer,Integer> map = new HashMap<>();
        // add values to map
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        // sort map by values in descending order 
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());

        // add top k elements 
        int [] ans= new int[k];
        for(int i=0;i<k;i++){
            ans[i]= list.get(i).getKey();
        }

        return ans;

    }
}
