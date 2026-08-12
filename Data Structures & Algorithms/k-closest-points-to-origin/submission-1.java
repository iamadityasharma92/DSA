class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // this works because of the property that if a>b then √a > √b
        // and also Euclidean formula for origin becomes √(x1)^2 + (y1)^2. --> so this helps in comparing to points distance
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->Integer.compare(b[0]*b[0]+b[1]*b[1],a[0]*a[0]+a[1]*a[1]));

        for(int[] i:points){
            q.add(i);
            if(q.size()>k){
                q.poll();
            }
        }
        // need to return k points each point have 2 coordinates 
        int[][] ans=new int[k][2];
        int idx=0;
        while(!q.isEmpty()){
            ans[idx++]=q.poll();
        }
        return ans;

    }
}
