class Solution {
    public int leastInterval(char[] tasks, int n) {
        // only the thing that matters is execution of tasks without any order or Name of task 
        //prepare freq array
        int[] freq=new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        // add these count to PQ max heap
        // we'll save only count here as there's no specific need of paring task name here 
        PriorityQueue<Integer> heap= new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i:freq){
            if(i>0){
                heap.offer(i);
            }
        }
        // make a queue which will help in cooldown and result time 
        int time=0;
        // on 0th idx we'll have freq remaining of task. 1st idx we'll have time on which task needs to be picked
        Queue<int[]> q= new LinkedList<>();
        while(!heap.isEmpty() || !q.isEmpty()){// both should be empty for loop to exit 
            time++;
            // 3 tasks to do here 
            //1. check if heap is empty change time from queue
            if(heap.isEmpty()){
                time=q.peek()[1];
            }else{
                int freqTask=heap.poll()-1;// cycle time was incremented in start of loop
                if(freqTask>0)
                q.add(new int[]{freqTask,time+n});
            }


            // 3. picking task back from queue i.e. adding back to heap

            if(!q.isEmpty() && q.peek()[1]==time){
                heap.add(q.poll()[0]);
            }
        }
        return time;
    }
}
