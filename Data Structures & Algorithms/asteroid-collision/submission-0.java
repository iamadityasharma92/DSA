class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s= new Stack<>();
        for(int i:asteroids){
            // boolean destroy=false;
            // stack should be non empty 
            // new entering element should be less than 0
            // top element of stack should be greater than 0
            while(!s.isEmpty() && i<0 && s.peek()>0){
                int d=i+s.peek();
                if(d<0){
                    // if entering element is greater than the peek element
                    s.pop();
                }else if(d>0){
                    // top element is greater
                    i=0;
                    // destroy=true;
                    break;
                }else{
                    // both will explode on if diff=0
                    i=0;
                    // destroy=true;
                    s.pop();
                    break;
                }
            }
            if(i!=0){
                s.push(i);
            }
        }
        return s.stream().mapToInt(Integer::intValue).toArray();
    }
}