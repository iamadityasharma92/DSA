class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length;
        while(l<r){
            int m=(l+r)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]>target){
                r=m;
            }else if(nums[m]<target){
                l=m+1;
            }
        }
        return -1;
    }
}
