class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] visited = new int[n];

        boolean bun =  dfs(-1 , 0 , visited , adj);
        for(int x : visited){
            if(x!=1) return false;
        }

        return bun;

        
    }

    private boolean dfs(int parent , int root , int[] visited ,  List<List<Integer>> adj){
        visited[root] = 1;
        boolean toReturn = true;
        for(int next : adj.get(root)){
            if(next == parent) continue;
            if(visited[next] == 1) return false;
            else toReturn = toReturn && dfs(root , next , visited , adj);
        }

        return toReturn;
        
    }
}
