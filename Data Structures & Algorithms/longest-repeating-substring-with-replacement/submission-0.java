class Solution {
    public int characterReplacement(String s, int k) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int hash[]=new int[26];
            int maxf=0,changes=0;
            for(int j=i;j<s.length();j++){
                hash[s.charAt(j)-'A']++;
                maxf=Math.max(maxf,hash[s.charAt(j)-'A']);
                changes=(j-i+1)-maxf;
                if(changes<=k){
                    ans=Math.max(ans,j-i+1);
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}
