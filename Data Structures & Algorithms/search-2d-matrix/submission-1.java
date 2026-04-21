class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // first search the row in which to search then we'll search in a row
        int m=matrix.length,n=matrix[0].length;
        if(n==1&&m==1){
            if(matrix[0][0]==target)
            return true;
            else 
            return false;
        }
        int l=0,r=m-1;
        while(l<=r){
            int mid=l+((r-l)/2);
            if(matrix[mid][0]==target){
                return true;
            }else if(matrix[mid][0]<target){
                l=mid+1;
            }else if(matrix[mid][0]>target){
                r=mid-1;
            }
        }
        // l would be that row
        // System.out.println(l--);
        l--;
        if(r<0)
        return false;
        int l1=0,r1=n-1;
        while(l1<=r1){
            int mid=l1+((r1-l1)/2);
            if(matrix[r][mid]==target){
                return true;
            }else if(matrix[r][mid]<target){
                l1=mid+1;
            }else if(matrix[r][mid]>target){
                r1=mid-1;
            }
        }
        return false;
    }
}
