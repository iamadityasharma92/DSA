class Solution {
    public int firstMissingPositive(int[] nums) {
        int n= nums.length;
        boolean [] bool=new boolean[100000+1];
        for(int num:nums){
            if(num>=0)
            bool[num]=true;
        }
        for(int i=1;i<bool.length;i++){
            if(bool[i]!=true){
                return i;
            }
        }
        return 1;
    }
}