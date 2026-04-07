class Solution {
    public int removeElement(int[] nums, int val) {
        int n= nums.length;
        if(n<=0) return 0;
        
        int i=-1,j;
        for(int k =0; k<n;k++){
            if(nums[k]==val){
                i=k;
                break;
            }
        }
        if(i==-1){
            return n;
        }
        j=i;
        while(j<n){
            if(nums[j]!=val){
                nums[i]=nums[j];
                nums[j]=val;
                i++;
            }
            j++;
        }
        return i;
    }
}