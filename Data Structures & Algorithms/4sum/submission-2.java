class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        if(n==4){
            if((long)nums[0]+nums[1]+nums[2]+nums[3]==target){
                return new ArrayList<>(Arrays.asList(List.of(nums[0],nums[1],nums[2],nums[3])));
            }else{
                return ans;
            }
        }
            Arrays.sort(nums);
            for(int i=0;i<=n-4;i++){
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> ret= threeSum(nums,i,target);
                ans.addAll(ret);
            }      
        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums,int a,int target) {
        int n=nums.length;
            List<List<Integer>> ans=new ArrayList<>();
            for(int i=a+1;i<=n-3;i++){
                if (i > a+1 && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> ret= find2Sum(nums,a,i,target);
                ans.addAll(ret);
            }      
        return ans;
        }
    public static List<List<Integer>> find2Sum(int[] nums,int a,int b,int target) {
        int c=b+1,d=nums.length-1;
        List<List<Integer>> ans=new ArrayList<>();

        while(c<d){
            long sum =(long)nums[a]+nums[b]+nums[c]+nums[d];
            if(sum==target){
                ans.add(List.of(nums[a],nums[b],nums[c],nums[d]));
                while (c < d && nums[c] == nums[c + 1]) c++;
                while (c < d && nums[d] == nums[d - 1]) d--;
                c++;
                d--;
            }else if(sum>target){
                d--;
            }else if(sum<target){
                c++;
            }
        }
        return ans;
    }
}