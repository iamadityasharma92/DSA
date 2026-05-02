class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(ch==')'||ch==']'||ch=='}'){
                if(st.isEmpty())return false;
                char top=st.pop();
                System.out.println(ch+" - "+top);
                if((ch==')'&&top!='(')||
                    (ch=='}'&&top!='{')||
                    (ch==']'&&top!='[')){
                    return false;                
                }
            }else{
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
}
