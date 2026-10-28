class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Map Method 
        Map<Integer,Integer> map= new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // sort map based on values 
        //trick
        List<Integer> sortedKeys=new ArrayList<>(map.keySet());
        sortedKeys.sort((a,b)->Integer.compare(map.get(b),map.get(a)));
        int[] res= new int[k];
        int c=0;
        while(k>0){
            res[--k]=sortedKeys.get(c++);
        }
        return res;
    }
}
