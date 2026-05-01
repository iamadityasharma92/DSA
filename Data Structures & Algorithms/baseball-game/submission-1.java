class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> ops=new Stack<>();
        for(String i:operations){
            if(i.equalsIgnoreCase("+")){
                int topScore=ops.pop();
                int sum = topScore+ops.peek();
                ops.push(topScore);
                ops.push(sum);
            }else if(i.equalsIgnoreCase("D")){
                int tmp=ops.peek();
                ops.push(tmp*2);
            }else if(i.equalsIgnoreCase("C")){
                ops.pop();
            }else{
                ops.push(Integer.parseInt(i));
            }

        }
        return sumOps(ops);
    }


    public int sumOps(Stack<Integer> ops){
        int sum=0;
        for(Integer i:ops){
            sum+=i;
        }
        return sum;
    }
}