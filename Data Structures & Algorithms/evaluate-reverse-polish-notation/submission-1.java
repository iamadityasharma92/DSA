class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String str=tokens[i];
            if(str.equals("+")){
                Integer a= s.pop();
                Integer b=s.pop();
                s.push(b+a);
            }else if(str.equals("-")){
                Integer a= s.pop();
                Integer b=s.pop();
                s.push(b-a);
            }else if(str.equals("*")){
                Integer a= s.pop();
                Integer b=s.pop();
                s.push(b*a);
            }else if(str.equals("/")){
                Integer a= s.pop();
                Integer b=s.pop();
                s.push(b/a);
            }else{
                s.push(Integer.parseInt(str));
            }
        }
        return s.pop();
    }
}
