class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        int n=n1+n2;
        if(n1>n2)
        return findMedianSortedArrays(nums2,nums1);
        int l=0,r=n1;
        double median=0.0;
        while(l<=r){
            int mid1=(l+r)/2;// no. of elements to be taken from nums1
            int mid2=((n1+n2+1)/2)- mid1;// no. of elements to be taken from nums2
            int l1= mid1==0?Integer.MIN_VALUE:nums1[mid1-1];// last element to be taken from nums1 in first half
            int l2= mid2==0?Integer.MIN_VALUE:nums2[mid2-1];// last element to be taken from nums2 in first half
            int r1= mid1==n1?Integer.MAX_VALUE:nums1[mid1];// first element from nums1 in second half
            int r2= mid2==n2?Integer.MAX_VALUE:nums2[mid2];// first element from nums2 in second half
            if(l1<=r2&&l2<=r1){
                // we get valid answer
                if(n%2==0){
                    median=(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else{
                    median = Math.max(l1,l2)/1.0;
                }
                return median;
            }else if(l1>r2){
                r=mid1-1;
            }else{
                l=mid1+1;
            }
        }
        return 0.0;
    }
}
