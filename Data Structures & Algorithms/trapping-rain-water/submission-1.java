class Solution {
    public int trap(int[] length) {
        int n=length.length;
        if(n==1)return 0;
        int ans=0,maxi=-1;
        int lm[]= new int[n];
        int rm[]= new int[n];
        for(int i=0;i<n;i++){
            lm[i]=Math.max(maxi,length[i]);
            maxi=Math.max(maxi,length[i]);
        }
        maxi=0;
        for(int i=n-1;i>=0;i--){
            rm[i]=Math.max(maxi,length[i]);
            maxi=Math.max(maxi,length[i]);
        }
        for(int i=0;i<n;i++){
            ans+=Math.min(rm[i],lm[i])-length[i];
        }
        return ans;
    }
}
