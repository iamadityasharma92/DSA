class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones)
        q.add(i);

        while(q.size()>1){
            int x=q.poll();
            int y=q.poll();
            if(x!=y){
                int n=Math.abs(x-y);
                q.add(n);
            }
        }

        return q.isEmpty()?0:q.peek();
    }
}
