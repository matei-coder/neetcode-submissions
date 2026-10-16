class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return Double.compare(dist(b[0] , b[1]),dist(a[0] , a[1]));
        });
        for(int [] point : points){
            pq.offer(point);
            if(pq.size() > k) pq.poll();
        }

        int[][] ans = new int[k][2];
        k--;
        
        while(k>=0){
            ans[k--] = pq.poll();
        }

        return ans;

    }

    private double dist(int x , int y){
        return Math.sqrt(x*x + y*y);
    }
}
