class Twitter {

    class Tweet{
        int id;
        int time;

        public Tweet(int id,int time){
            this.id=id;
            this.time=time;
        }
    }
    // userId-> list of followers
    // userId -> list of tweets 
    Map<Integer,Set<Integer>> followMap;// set to avoid duplicate followers
    Map<Integer,List<Tweet>> tweetMap;
    Integer counter;// for attaching timeStamp with tweet
    public Twitter() {
        followMap= new HashMap<>();
        tweetMap=new HashMap<>();
        counter=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet t=new Tweet(tweetId,counter++);
        tweetMap.computeIfAbsent(userId,k->new ArrayList<>()).add(t);
        // if(tweetMap.containsKey(userId)){
        //     tweetMap.get(userId).add(t);
        // }else{
        //     List<Tweet> list=new ArrayList<>();
        //     list.add(t);
        //     tweetMap.put(userId,list);
        // }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> users= new ArrayList<>();// target users
        users.add(userId);
        if(followMap.containsKey(userId))
        users.addAll(followMap.get(userId));
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a.time,b.time));

        // iterate for all users 
        for(Integer user:users){
            List<Tweet> tweets=tweetMap.get(user);
            if(tweets==null) continue;
            // iterate on last 10 tweets of every user only 
            for(int i=Math.max(0,tweets.size()-10);i<tweets.size();i++){// maxi because not compulsory that every list will have min. 10 tweets
                minHeap.add(tweets.get(i));
                if(minHeap.size()>10){
                    minHeap.poll();
                }
            }
        }
        List<Integer> res= new LinkedList<>();
        while(!minHeap.isEmpty()){
            res.add(0,minHeap.poll().id);// this add values from front 
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)
        return;
        followMap.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);

        // if(followMap.containsKey(followerId)){
        //     followMap.get(followerId).add(followeeId);
        // }else{
        //     followMap.put(followerId,new HashSet<>(Set.of(followeeId)));
        // }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId)
        return;

        if(followMap.containsKey(followerId)){// this is will work as list of followers is also an Object 
            followMap.get(followerId).remove(followeeId);
        }
    }
}
