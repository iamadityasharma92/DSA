class Solution {
    static class Pair{
        int[] point;
        double distance;
        
        public Pair(int[] point,double distance){
            this.point=point;
            this.distance=distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->Double.compare(b.distance,a.distance));

        for(int[] i:points){
            double d =findDistance(i);
            Pair p=new Pair(i,d);
            q.add(p);
            if(q.size()>k){
                q.poll();
            }
        }
        int[][] ans=new int[k][2];
        int idx=0;
        while(!q.isEmpty()){
            ans[idx++]=q.poll().point;
        }
        return ans;

    }

    double findDistance(int[] point){
        return Math.sqrt(Math.abs(Math.pow(point[0],2)-Math.pow(0,2))+Math.abs(Math.pow(point[1],2)-Math.pow(0,2)));
    }
}
