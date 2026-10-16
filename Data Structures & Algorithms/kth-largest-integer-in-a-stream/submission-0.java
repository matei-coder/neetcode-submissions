class KthLargest {
    private final PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a,b)->{
            return a - b;
        });
        for(int x:nums){
            pq.add(x);
             if(pq.size()>k){
            pq.poll();
        }
        }
        this.k =k;
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}
