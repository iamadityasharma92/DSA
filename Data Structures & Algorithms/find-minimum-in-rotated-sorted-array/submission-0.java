class Solution {
    public int findMin(int[] nums) {
        // brute force 
        int mini=Integer.MAX_VALUE;
        for(int i:nums)
        mini=Math.min(mini,i);
        return mini;
    }
}
