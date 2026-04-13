class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        if(n==3){
            if(nums[0]+nums[1]+nums[2]==0){
                return new ArrayList<>(Arrays.asList(List.of(nums[0],nums[1],nums[2])));
            }else{
                return ans;
            }
        }
            Arrays.sort(nums);
            for(int i=0;i<=n-3;i++){
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> ret= find2Sum(nums,i);
                ans.addAll(ret);
            }      
        return ans;
        }
    public static List<List<Integer>> find2Sum(int[] nums,int a) {
        // System.out.println(nums+" "+a);
        int b=a+1,c=nums.length-1;
        List<List<Integer>> ans=new ArrayList<>();

        while(b<c){
            int sum = nums[a]+nums[b]+nums[c];
            if(sum==0){
                ans.add(List.of(nums[a],nums[b],nums[c]));
                while (b < c && nums[b] == nums[b + 1]) b++;
                while (b < c && nums[c] == nums[c - 1]) c--;
                b++;
                c--;
            }else if(sum>0){
                c--;
            }else if(sum<0){
                b++;
            }
        }
        return ans;
    }


}
