class Solution {
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length;
        while(l<=r){
            int m=l+((r-l)/2);
            if(m>0 && nums[m-1]>nums[m]){
                r=m-1;
            }else if(m<nums.length-1 && nums[m]<nums[m+1]){
                l=m+1;
            }else{
                return m;
            }
        }
        return l;
    }
}