/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // binary search 
        int l=0,r=n;
        while(l<r){
            int m=l+((r-l)/2);
            int check = guess(m);
            if(check==0)return m;
            else if(check==1)l=m+1;
            else if(check==-1)r=m;
        }
        return n;
        
    }
}