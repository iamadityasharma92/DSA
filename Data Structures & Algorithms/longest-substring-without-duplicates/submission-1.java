class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        int l=0,r=0,maxi=0;
        Set<Character> set=new HashSet<>();
        while(r<s.length()){
            if(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }else{
                set.add(s.charAt(r));
                r++;
                maxi=Math.max(set.size(),maxi);
            }
        }
        return maxi;
    }
}
