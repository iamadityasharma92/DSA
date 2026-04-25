class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(n<k){
            return -1;
        }
        int l=0,r=0;
        for(int num:nums){
            l=Math.max(l,num);
            r+=num;
        }
        int res=-1;
        while(l<=r){
            int m = l+((r-l)/2);
            System.out.println(m+" "+canSplit(nums,m,k));
            if(canSplit(nums,m,k)){
                res=m;
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return res;
    }

    public boolean canSplit(int[] nums,int m, int k){
        int sum=0,c=1;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>m){
                c++;
                sum=nums[i];
            }
            if(c>k){
                return false;
            }
        }
        return true;
    }
}