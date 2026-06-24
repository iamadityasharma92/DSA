class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-97]++;
        }
        for(char ch:t.toCharArray()){
            freq[ch-97]--;
            if(freq[ch-97]<0){
                return false;
            }
        }
        return true;
    }
}
