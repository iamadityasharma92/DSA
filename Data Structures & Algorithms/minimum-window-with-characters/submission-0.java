class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
        return "";
        String ans="";
        int ansCount=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<=s.length();j++){
                String sub=s.substring(i,j);
                if(isSubset(sub,t)){
                    if(ansCount>sub.length()){
                        ansCount=sub.length();
                        ans=sub;
                    }
                    break;
                }
            }
        }
        return ans;
    }
    public boolean isSubset(String a, String b) {
    int[] counts = new int[256]; 
    for (char c : a.toCharArray()) counts[c]++;
    for (char c : b.toCharArray()) {
        if (--counts[c] < 0) return false;
    }
    return true;
}
}
