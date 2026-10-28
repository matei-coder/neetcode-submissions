class Solution {

    

    public List<Boolean> checkIfPrerequisite(int numCourses, 
    int[][] prerequisites, int[][] queries) {
        int n = numCourses;

        Map<Integer ,Set<Integer>> prereq = new HashMap<>();
        for(int i=0;i<n;i++) prereq.put(i , new HashSet<>());
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] inDeg = new int[numCourses];

        for(int[] pre : prerequisites){
            adj.get(pre[0]).add(pre[1]);
            inDeg[pre[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) if(inDeg[i] == 0) q.add(i);

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next : adj.get(curr)){
                prereq.get(next).add(curr);
                prereq.get(next).addAll(prereq.get(curr));
                inDeg[next]--;
                if(inDeg[next] == 0){
                    q.add(next);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for(int[] query : queries){
            if(prereq.get(query[1]).contains(query[0])) ans.add(true);
            else ans.add(false);
        }


        return ans;





    }

    
}