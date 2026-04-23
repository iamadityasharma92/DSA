class Solution {
    public int findMin(int[] nums) {
        // optimal using binary search 
        //breaking point will have the minimum value 
        int l=0,r=nums.length-1;
        int mini=Integer.MAX_VALUE;
        while(l<=r){
            int m=l+((r-l)/2);
            mini=Math.min(mini,nums[m]);
            if(nums[m]<nums[r]){
                r=m-1;
            }else{
                l=m+1; 
            }
        }
        return mini;
    }
}
