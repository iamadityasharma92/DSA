class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1,r=0;
        for(int i:piles){
            r=Math.max(r,i);
        }
        while(l<=r){
            int m=l+((r-l)/2);

            int time=0;
            for(int pile:piles){
                time+=Math.ceil((double)pile/m);
            }
            if(time<=h){
                r=m-1;
            }else {
                l=m+1;
            }
        }
        return l;
    }
}
