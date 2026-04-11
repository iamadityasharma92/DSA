class Solution {
    public void rotate(int[] nums, int k) {
        // reverse reverse khelna hai 
        int n=nums.length;
        if(n==1)return;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        // reverse(nums,0,n-1);
    }

    public void reverse(int[] nums,int l,int r){
        while(l<r){
            int t=nums[l];
            nums[l]=nums[r];
            nums[r]=t;
            l++;
            r--;
        }
    }
}