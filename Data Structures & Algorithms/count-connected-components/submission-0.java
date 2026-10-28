class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] pre : edges){
            adj.get(pre[0]).add(pre[1]);
            adj.get(pre[1]).add(pre[0]);    
        }
        int[] visited = new int[n];

        int comp = 0;

        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                comp++;
                dfs(i , visited , adj);
            }
        }

        return comp;



    }
    private void dfs(int curr , int[] visited , List<List<Integer>> adj ){
        visited[curr] = 1;
        for(int next : adj.get(curr)){
            if(visited[next] == 0){
                dfs(next , visited , adj);
            }
        }

    }
}
