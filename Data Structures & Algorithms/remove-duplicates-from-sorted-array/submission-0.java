class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==1)return 1;
        int l=0,r=0;
        while(r<nums.length){
            if(nums[l]==nums[r]){
                r++;
            }else {
                nums[++l]=nums[r++];
            }
        }
        return ++l;
    }
}