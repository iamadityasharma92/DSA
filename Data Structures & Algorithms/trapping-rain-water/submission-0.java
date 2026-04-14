class Solution {
    public int trap(int[] length) {
        int n=length.length;
        if(n==1)return 0;
        int ans=0;
        for(int i=0;i<n;i++){
            int l=i-1,r=i+1,lm=length[i],rm=length[i];
            while(l>=0){
                lm=Math.max(lm,length[l]);
                l--;
            }
            while(r<n){
                rm=Math.max(rm,length[r]);
                r++;
            }
            ans+=(Math.min(lm,rm)-length[i]);
        }
        return ans;
        
    }
}
