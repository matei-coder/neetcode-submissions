class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            if(Math.abs(a - x) == Math.abs(b - x)){
                return b - a;
            }
            return -(Math.abs(a - x) - Math.abs(b - x)); 
            
        });

        for(int val : arr){
            pq.add(val);
            if(pq.size() > k) pq.poll();
        }

        List<Integer> ans = new ArrayList<>();

        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        Collections.sort(ans);
        return ans;
    }
}