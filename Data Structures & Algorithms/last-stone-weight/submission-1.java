class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });

        for(int stone : stones){
            pq.add(stone);
        }
        while(pq.size()>1){     
                int x = pq.poll();
                int y = pq.poll();
                if(x == y){
                    continue;
                }else if(x > y){
                    pq.add(x-y);
                }       
        }
        return (pq.isEmpty()) ? 0 : pq.poll();

    }
}
