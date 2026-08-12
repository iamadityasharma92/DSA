class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // this works because of the property that if a>b then √a > √b
        // and also Euclidean formula for origin becomes √(x1)^2 + (y1)^2. --> so this helps in comparing to points distance
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->Integer.compare(b[0]*b[0]+b[1]*b[1],a[0]*a[0]+a[1]*a[1]));

        for(int[] i:points){
            if (q.size() < k) {
                    q.add(i);
                } else {
                    // Calculate current point's distance
                    int currDist = i[0] * i[0] + i[1] * i[1];
                    // Peek at the max distance currently in the heap
                    int[] maxPoint = q.peek();
                    int maxDist = maxPoint[0] * maxPoint[0] + maxPoint[1] * maxPoint[1];
                    
                    // Only add if it's strictly closer than the farthest point in our top-K list
                    if (currDist < maxDist) {
                        q.poll();
                        q.add(i);
                    }
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
