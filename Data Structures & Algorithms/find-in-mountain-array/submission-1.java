/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIdx = findPeak(mountainArr);
        if(peakIdx<0){
            return -1;
        }
        System.out.println(peakIdx);
        int idx=-1;
        idx=binarySearch(mountainArr,target,0,peakIdx,true);
        if(idx!=-1)
        return idx;
        idx=binarySearch(mountainArr,target,peakIdx+1,mountainArr.length(),false);
        return idx;
    }

    public int binarySearch(MountainArray nums,int target,int l,int r,boolean isAscending){
        // we should have different conditions for ascending and descending phase of a peak
        while(l<=r){
            int m=l+((r-l)/2);
            int num=nums.get(m);
            if(num==target)return m;
            if(isAscending){
                if(num<target){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }else{
                if(num<target){
                    r=m-1;
                }else{
                    l=m+1;
                }

            }

        }
        return -1;
    }

    public int findPeak(MountainArray nums){
        int n= nums.length();
        int l=0,r=n-1;
        while(l<=r){
            int m=l+((r-l)/2);
            int num=nums.get(m);
            if(m>0 && nums.get(m-1)>num){
                r=m-1;
            }else if(m<nums.length()-1 && nums.get(m+1)>num){
                l=m+1;
            }else{
                return m;
            }
        }
        return -1;
    }
}