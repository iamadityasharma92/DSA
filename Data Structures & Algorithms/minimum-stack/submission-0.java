class MinStack {
    Stack<Integer> s;
    public MinStack() {
        s=new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        Stack<Integer> temp=new Stack<>();
        int mini=Integer.MAX_VALUE;
        while(!s.isEmpty()){
            mini=Math.min(mini,s.peek());
            temp.add(s.pop());
        }

        while(!temp.isEmpty())
        s.push(temp.pop());

        return mini;
    }
}
