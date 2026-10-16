class Twitter {
    class Tweet{
        int id;
        int userId;
        Tweet next;
        int time;

        Tweet(int id , int userId , Tweet next , int time){
            this.id = id;
            this.userId = userId;
            this.next = next;
            this.time = time;
        }
    }

    Map<Integer , Tweet> tweets;
    Map<Integer , Set<Integer>> following;
    int time ;

    public Twitter() {
        tweets = new HashMap<>();
        time = 0;
        following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)) tweets.put(userId , null);
        Tweet newTweet = new Tweet(tweetId , userId , tweets.get(userId) , time++);
        tweets.put( userId, newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq =new PriorityQueue<>((a,b)->{
            return b.time - a.time;
        });

        List<Integer> ans = new ArrayList<>();
        
        if( following.get(userId) != null) 
        for(int pers: following.get(userId)){
            pq.add(tweets.get(pers));
        }

        if(tweets.containsKey(userId))
        pq.add(tweets.get(userId));

        while(!pq.isEmpty() && ans.size() < 10){
            Tweet first = pq.poll();
            ans.add(first.id);
            first = first.next;
            if(first!=null) pq.add(first);
        }

        return ans;
        
        
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)) following.put(followerId , new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!following.containsKey(followerId) || 
        !following.get(followerId).contains(followeeId)) return;
        following.get(followerId).remove(followeeId);
    }
}
