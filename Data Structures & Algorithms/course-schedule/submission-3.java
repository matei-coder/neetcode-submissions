class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int[] prereq : prerequisites){
            adj.get(prereq[0]).add(prereq[1]);
        }
        int[] onPath = new int[numCourses];
        int[] visited = new int[numCourses];

        boolean toReturn = true;
        for(int i=0;i<numCourses;i++){
            if(visited[i] == 0)
            toReturn = toReturn && dfs(adj , i , onPath , visited);
        }

        return toReturn;
      
    }
    private boolean dfs(List<List<Integer>> adj , int root , int[] onPath , int[] visited){
        onPath[root] = 1;
        visited[root] = 1;

        boolean toReturn = true;

        for(int next : adj.get(root)){
            if(onPath[next] == 1) return false;
            if(visited[next] == 0){
                toReturn = toReturn && dfs(adj , next , onPath , visited);
            }
        }

        onPath[root] = 0;

        return toReturn;
    }
}
