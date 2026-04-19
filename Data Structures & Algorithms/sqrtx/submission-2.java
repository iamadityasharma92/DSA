class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1) return 1;
        long l=0,r=x;
        while(l<r){
            long m=l+((r-l)/2);
            long sqr=m*m;
            if(sqr==x){
                return (int)m;
            }else if(sqr>x){
                r=m;
            }else {
                l=m+1;
            }
        }
        return (int)l-1;
    }
}