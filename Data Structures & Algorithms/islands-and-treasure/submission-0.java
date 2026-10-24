class Solution {
    final int INF = 2147483647;
    private final int[] dx = {-1 , 1 , 0, 0};
    private final int[] dy = {0 , 0, -1 , 1};

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0) q.add(new int[]{i , j});
            }
        } 

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int i=0;i<4;i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX>=0 && newX<grid.length&&
                    newY>=0 && newY<grid[0].length&&
                        grid[newX][newY] == INF){
                            grid[newX][newY] = grid[x][y]+1;
                            q.add(new int[]{newX , newY});
                }
            }

        }



    }
}
