class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0,r=people.length-1,c=0;
        while(l<=r){
            int sum=people[l]+people[r];
            if(sum<=limit){
                c++;
                r--;
                l++;
            }else if(sum>limit){
                c++;
                r--;
            }else if(sum<limit){
                l++;
            }
        }
        return c;
    }
}