class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
        return "";
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c= t.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count=map.size();
        int i=0,j=0,minLen=Integer.MAX_VALUE,startIdx=0;
        while(j<s.length()){
            char rightCh=s.charAt(j);
            if(map.containsKey(rightCh)){
                // if valid character found decrease its frequency
                map.put(rightCh,map.get(rightCh)-1);
                if(map.get(rightCh)==0){
                    count--;
                }
            }
            // shrink window if found a valid solution
            while(count==0){
                //check for windowLength in case of valid answer and store window start and length
                if(j-i+1<minLen){
                    minLen=j-i+1;
                    startIdx=i;
                }
                char leftCh=s.charAt(i);
                if(map.containsKey(leftCh)){
                    map.put(leftCh,map.get(leftCh)+1);
                    if(map.get(leftCh)>0){
                        count++;
                    }
                }

                i++;
            }

            j++;
        }

        return minLen==Integer.MAX_VALUE?"":s.substring(startIdx,startIdx+minLen);
    }
}
