class Solution {
    public int maxProfit(int[] prices) {
        int l=0,r=0;
        int maxi=0,n=prices.length;
        while(r<n){
            if(prices[r]<prices[l]){
                l=r;
            }
            else if(prices[r]>prices[l]){
                maxi=Math.max(prices[r]-prices[l],maxi);
            }
            r++;
        }
        return maxi;
    }
}
