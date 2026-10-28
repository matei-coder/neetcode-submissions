class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses ; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDeg = new int[numCourses];

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            inDeg[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[numCourses];
        int k =0;

        for(int i=0;i<numCourses;i++) if(inDeg[i]==0) q.add(i);

        while(!q.isEmpty()){
            int curr = q.poll();
            ans[k++] = curr;
            for(int next : adj.get(curr)){
                inDeg[next]--;
                if(inDeg[next]==0) q.add(next);
            }
        }

        return (k == numCourses) ? ans : new int[]{};


        
    }

}
