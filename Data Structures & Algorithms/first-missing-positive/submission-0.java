class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxi=Integer.MIN_VALUE;
        for(int num:nums){
            set.add(num);
            maxi=Math.max(maxi,num);
        }
        if(maxi<0){
            return 1;
        }
        for(int i=1;i<=maxi;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return maxi>0?maxi+1:1;
    }
}