class Solution {
    public int majorityElement(int[] nums) {
        int leader=nums[0],vote=1;
        for(int i=1;i<nums.length;i++){
            if(vote==0){
                leader=nums[i];
                vote=1;
                continue;
            }
            if(leader==nums[i]){
                vote++;
            }else{
                vote--;
            }
        }
        return leader;
    }
}