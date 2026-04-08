class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        // if(n==1)return new ArrayList<>(Arrays.toList(nums));
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> ans= new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>(n/3)){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}