class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>res=new HashMap<>();
        for(int i=0;i<strs.length;i++){
        char[] chars = strs[i].toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        res.putIfAbsent(sorted,new ArrayList<>());
        res.get(sorted).add(strs[i]);
        }

        return new ArrayList<>(res.values());
    }
}
