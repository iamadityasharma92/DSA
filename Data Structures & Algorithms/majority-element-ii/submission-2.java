class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int cand1=-1,cand2=-1,c1=0,c2=0;
        //finding candidates
        for(int i:nums){
            if(cand1==i)c1++;
            else if(cand2==i)c2++;
            else if(c1==0){
                cand1=i;
                c1=1;
            }else if(c2==0){
                cand2=i;
                c2=1;
            }else{
                c1--;
                c2--;
            }
        }
        List<Integer> ans= new ArrayList<>();
        // re-verify whether candidates are authentic or not 
        c1=c2=0;
        for(int i:nums){
            if(cand1==i)c1++;
            else if(cand2==i)c2++;
        }
        if(c1>n/3) ans.add(cand1);
        if(c2>n/3) ans.add(cand2);
        return ans;
    }
}