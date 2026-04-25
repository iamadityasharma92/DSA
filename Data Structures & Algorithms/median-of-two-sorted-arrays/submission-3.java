class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //using merging logic but finding only elements that can be used for median 
        int n1=nums1.length,n2=nums2.length;
        int n=n1+n2;
        int p1=0,p2=0;
        int current=0,prev=0;
        for(int i =0;i<=n/2;i++){
            prev=current;
            // p1<n1-> for out of bound, p2>=n2-> ensures if p2 is exhausted pick from nums1, nums[p1]<nums[p2]->pick the smaller element
            if(p1<n1&&(p2>=n2||nums1[p1]<nums2[p2])){
                current=nums1[p1++];
            }else{
                current=nums2[p2++];
            }
        }
        double median=0.0;
        if(n%2==0){
            median=(prev+current)/2.0;
        }else{
            median=current/1.0;
        }
        return median;
    }
}
