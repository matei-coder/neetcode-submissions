class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1];
        int[] size = new int[n+1];
        for(int i=0;i<=n;i++){
            par[i] = i;
            size[i] = 1;
        }

        for(int[] edge : edges){
            if(!union(edge[0] , edge[1] , par , size)){
                return edge;
            }
        }

        return new int[0];
    }
    private int find(int a , int[] par ){
        int p = par[a];
        while(p!=par[p]){
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    private boolean union(int a , int b , int[] par , int[] size){
        int p1 = find(a , par);
        int p2 = find(b , par);

        if(p1 == p2){
            return false;
        }
        if(size[a] > size[b]){
            par[p2]= p1;
            size[p1]+=size[p2];
        }else{
            par[p1]= p2;
            size[p2]+=size[p1];
        }
        return true;
    }
}
