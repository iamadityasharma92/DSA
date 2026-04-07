class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        if(n == 1) return nums[0];
        int count=1, cand=nums[0];
        for(int i=1;i<n;i++){
            if(cand==nums[i]){
                count++;
            }else if(cand!=nums[i]){
                count--;
            }
            if(count==0){
                cand=nums[i];
                count=1;
            }
        }
        return cand;
    }
}