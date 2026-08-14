class Solution {
    public int leastInterval(char[] tasks, int n) {
        // first we need to find frequency of each task 
        // as given task[i]-> A to Z we can use freq array 
        int[] freq = new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        // as we have cooldown of n cycles for identical task -> we'll priortize executing more frequent tasks first
        // either we can sort and do the same stuff every time 
        // or we can use a data structure which always gives largest element in O(1)
        // we'll be using max heap for this 
        PriorityQueue<Integer> heap= new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i:freq){
            if(i>0)
            heap.add(i);
        }
        // how to apply cooldown while executing tasks 
        // we'll execute tasks decrease its freq by 1 hold it till its time for execution occurs then again push it to PQ
        // for holding the task we'll build a queue
        Queue<int[]> q= new LinkedList<>();
        // arr[0]-> count or freq of task , arr[1]-> this will hold the time of releasing 
        int time=0;
        while(!heap.isEmpty() || !q.isEmpty()){
            time++;
            // check if heap is empty -> if yes assign it with queue's top elements time as there can be cases when heap becomes empty but queue have elements with releasing time 
            if(heap.isEmpty()){
                time = q.peek()[1];
            }else{
                int freqTask= heap.poll()-1;// execute one time
                if(freqTask>0){
                    q.add(new int[]{freqTask,time+n});// for cooldown of n 
                }
            }
            // add task back to heap on time
            if(!q.isEmpty() && time==q.peek()[1]){
                heap.add(q.poll()[0]);
            }
        }
        return time;
    }
}
