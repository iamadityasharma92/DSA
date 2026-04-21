class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // can't we do it in one iteration last time we did it in log(m)+log(n)=log(m*n)
        // can we do it in one iteration
        // can we somehow treat this 2D array to 1D array 
        // if we have idx iterating all through then idx/m = row, idx%n= col
        int m=matrix.length,n=matrix[0].length;
        int l=0,r=(m*n)-1;
        while(l<=r){
            int mid = l+((r-l)/2);
            int midval= matrix[mid/n][mid%n];
            if(midval==target)
            return true;
            else if(midval<target){
                l=mid+1;
            }else if(midval>target){
                r=mid-1;
            }
        }
        return false;
    }
}
