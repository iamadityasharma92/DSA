class Solution {
    public int[] twoSum(int[] nums, int k) {
        int l=0,r=nums.length-1;
        while(l<r){
            int sum=nums[l]+nums[r];
            if(sum==k){
                return new int[]{l+1,r+1};
            }else if(sum<k){
                l++;
            }else if(sum>k){
                r--;
            }
        }
        return new int[2];
    }
}
