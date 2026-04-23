class Solution {
    public int search(int[] nums, int target) {
      //brute force
        int l=0,r=nums.length-1;
        while(l<=r){
            int m=l+((r-l)/2);
            if(target==nums[m]){
                return m;
            }else if(nums[m]>=nums[l]){// if left half is sorted 
                if(target>=nums[l]&& target<nums[m])// check if it lies in left half or not
                    r=m-1;
                else
                    l=m+1;
            }else{
                if(target>nums[m]&& target<=nums[r])// check if it lies in right half or not
                    l=m+1;
                else
                    r=m-1;
            }
        }
        return -1;
    }
}
