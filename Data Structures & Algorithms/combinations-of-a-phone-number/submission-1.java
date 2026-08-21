class Solution {
    String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String str) {

         if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }
        return getKPC(str);
    }

     List<String> getKPC(String str) {
        if(str.isEmpty())
            return new ArrayList<>(Arrays.asList(""));// atleast size becomes 1
        char ch=str.charAt(0);
        List<String> temp= getKPC(str.substring(1));
        List<String> res= new ArrayList<>();
        int n=temp.size();
        String key = codes[ch-'0'];
        for(int i=0;i<key.length();i++) {
            char c=key.charAt(i);

            for (int j = 0; j < n; j++) {
                res.add(c + temp.get(j));
            }
        }
        return res;
    }
}
