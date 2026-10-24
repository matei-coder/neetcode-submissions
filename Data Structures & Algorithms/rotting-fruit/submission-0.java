class Solution { 

    int n,m;
    private final int[] dx = {-1 , 1 , 0, 0};
    private final int[] dy = {0 , 0 , 1 , -1};


    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[][] time = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i , j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int i=0;i<4;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];
                if(newX >=0 && newX < n && 
                    newY>=0 && newY<m && 
                    grid[newX][newY] == 1 && time[newX][newY]==0){

                        q.add(new int[]{newX , newY});
                        time[newX][newY] = time[x][y]+1;
                }
            }
        }

        int maxTime = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //System.out.print(time[i][j]+" ");
                if(grid[i][j] == 1 && time[i][j] == 0){
                    return -1;
                }
                maxTime = Math.max(maxTime , time[i][j]);
                
            }
            //System.out.println("");
        }


        return maxTime;




    }

    
}
