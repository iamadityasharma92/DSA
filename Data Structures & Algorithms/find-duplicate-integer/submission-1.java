class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> freq= new HashSet<>();
        for(int num:nums){
            if(!freq.add(num)){
                return num;
            }
        }
        return -1;
    }
}
