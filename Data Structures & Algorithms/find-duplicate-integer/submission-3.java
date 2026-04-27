class Solution {
    public int findDuplicate(int[] nums) {
        // using the same array as hashset
        // how ??
        // we'll be storing -nums[i] on each passed index and then if we encounter already negative value there we found a duplicate 
        // nums[abs[nums[i]-1]]*=-1

        for(int i:nums){
            if(nums[Math.abs(i)-1]<0){
                return Math.abs(i);
            }
            nums[Math.abs(i)-1]*=-1;
        }
        return -1;
    }
}
