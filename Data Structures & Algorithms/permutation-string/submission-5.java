class Solution {
    public boolean checkInclusion(String s1, String s2) {
    char[] chars1 = s1.toCharArray();
    Arrays.sort(chars1);
    s1 = new String(chars1);
    int n1=s1.length(),n2=s2.length();
    int l=0,r=0;
    while(r<n2){
        if(r-l+1<n1){
            r++;
        }else{
            if(checkIfPresent(s1,s2.substring(l,l+n1))){
                return true;
            }else{
                l++;
                r++;
            }
        }
    }
    return false;
    }
    public boolean checkIfPresent(String s1,String s2){
    char[] chars2 = s2.toCharArray();
    Arrays.sort(chars2);
    String sorted2 = new String(chars2);
    return s1.equals(sorted2);
    }
}
