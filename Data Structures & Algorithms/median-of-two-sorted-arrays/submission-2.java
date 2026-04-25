class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        int [] arr=new int[n1+n2];
        //merge arrays
        int p1=0,p2=0,i=0;
        while(p1<n1 && p2<n2){
            if(nums1[p1]<nums2[p2]){
                arr[i]=nums1[p1++];
            }else{
                arr[i]=nums2[p2++];
            }
            i++;
        }
        if(p1<n1){
            for(int j=p1;j<n1;j++){
                arr[i++]=nums1[j];
            }
        }
        if(p2<n2){
            for(int j=p2;j<n2;j++){
                arr[i++]=nums2[j];
            }
        }
        // now find median
        int mid=arr.length/2;
        double median=0.0;
        if(arr.length%2==0){
            median=(arr[mid-1]+arr[mid])/2.0;
        }else{
            median=arr[mid]/1.0;
        }
        return median;
    }
}
