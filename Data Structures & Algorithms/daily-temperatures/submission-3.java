class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] res=new int[temp.length];
        Stack<int[]> s= new Stack<>();
        for(int i=0;i<temp.length;i++){
            int t=temp[i];
            while(!s.isEmpty()&&t>s.peek()[0]){
                int[] pair=s.pop();
                res[pair[1]]=i-pair[1];
            }
            s.push(new int[]{t,i});
        }
        return res;
    }
}
