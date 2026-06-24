class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map= new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                int idx1=i;
                int idx2=map.get(target-nums[i]);
                return new int[]{idx2,idx1};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
