class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // minimum capacity = mini of weights, maxiumum capacity would be sum of weights 
        int l=0,r=0,ans=Integer.MAX_VALUE;
        for(int i:weights){
            l=Math.max(l,i);
            r+=i;
        }
        ans=r;
        while(l<r){
            int m=l+((r-l)/2);
            //now check on this capacity can we ship weights 
            if(canShip(m,weights,days)){
                ans=Math.min(ans,m);
                r=m;
            }else{
                l=m+1;
            }
        }
        return ans;
    }

    public boolean canShip(int cap,int[] weights, int days){
        int sum=0,d=1;
        for(int i:weights){
            if(sum+i>cap){
                d++;
                sum=i;
            }else{
                sum+=i;
            }
        }
        return d<=days;
    }
}