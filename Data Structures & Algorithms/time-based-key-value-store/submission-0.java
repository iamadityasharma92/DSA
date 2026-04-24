public class TimeStampValue{
    public int timestamp;
    public String value;

    public TimeStampValue(int timestamp,String value){
        this.timestamp=timestamp;
        this.value=value;
    }

    public int getKey(){
        return timestamp;
    }
    public String getValue(){
        return value;
    }
}

class TimeMap {
    Map<String,List<TimeStampValue>> map;


    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // simple add in map and if already present add in existing list of specific key
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        List<TimeStampValue> list= map.get(key);
        list.add(new TimeStampValue(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        // get list from map and then perform binary search on it 
        List<TimeStampValue> list= map.get(key);
        String ans="";
        if(list != null){
            int l=0,r=list.size()-1;
            while(l<=r){
                int m=l+((r-l)/2);
                if(list.get(m).getKey()<=timestamp){
                    ans=list.get(m).getValue();
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
        }
        return ans;
    }
}
