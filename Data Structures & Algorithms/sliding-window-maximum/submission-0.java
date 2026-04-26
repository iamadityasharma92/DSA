class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i=0,j=k,n=nums.length,c=0;
        int[] ans= new int[n-k+1];
        while(j<=n){
            int maxi=getMax(nums,i,j);
            ans[c]=maxi;
            c++;
            j++;
            i++;
        }
        return ans;
    }

    public int getMax(int[] nums,int i,int j){
        int maxi=Integer.MIN_VALUE;
        for(int k=i;k<j;k++){
            maxi=Math.max(maxi,nums[k]);
        }
        return maxi;
    }
}
