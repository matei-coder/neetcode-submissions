class Solution {
    private final int[] dx = {-1 , 1 , 0 , 0};
    private final int[] dy = {0 , 0 , -1 , 1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] reachableP = new int[n][m];
        int[][] reachableA = new int[n][m];

        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0;i<m;i++){
            q.add(new int[]{0 , i});
            reachableP[0][i]=1;
        }
        for(int i=0;i<n;i++){
            q.add(new int[]{i , 0});
            reachableP[i][0]=1;
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int i=0;i<4;i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX >=0 && newX<n 
                && newY >=0 && newY<m
                && heights[x][y]<=heights[newX][newY]
                && reachableP[newX][newY]==0){
                    reachableP[newX][newY]++;
                    q.add(new int[]{newX, newY});
                }
            }
        }

        q.clear();

        for(int i=0;i<m;i++){
            q.add(new int[]{n-1 , i});
            reachableA[n-1][i]=1;

        }
        for(int i=0;i<n;i++){
            q.add(new int[]{i , m-1});
            reachableA[i][m-1]=1;
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int i=0;i<4;i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX >=0 && newX<n 
                && newY >=0 && newY<m
                && heights[x][y]<=heights[newX][newY] 
                && reachableA[newX][newY] == 0){
                    reachableA[newX][newY]++;
                    q.add(new int[]{newX, newY});
                }
            }
        }
        List<List<Integer>> ans =new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(reachableA[i][j] ==1 && reachableP[i][j] == 1){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }


        return ans;




    }
}
