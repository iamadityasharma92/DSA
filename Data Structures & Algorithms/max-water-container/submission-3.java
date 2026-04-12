class Solution {
    public int maxArea(int[] nums) {
        int l=0,r=nums.length-1;
        int ans=0;
        while(l<r){
            int area=(r-l)*(Math.min(nums[l],nums[r]));
            if(nums[l]<=nums[r]){
                l++;
            }
            else if(nums[l]>nums[r]){
                r--;
            }
            ans=Math.max(area,ans);
        }
        return ans;
    }
}
