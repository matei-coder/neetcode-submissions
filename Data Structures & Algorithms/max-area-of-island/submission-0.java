class Solution {

    private final int[] dx ={-1 , 1, 0 , 0};
    private final int[] dy ={0 , 0 , -1 ,1};

    int ans = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int biggestIsland = 0;
        for(int i =0;i<grid.length ;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] ==1){
                    grid[i][j] =2;
                    ans = Math.max(ans, dfs(i , j , grid ));
                }
            }
        }

        return ans;
        
    }

    private int dfs(int x , int y , int[][] grid){
        int sum =1;

        for(int i = 0;i<4;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >=0 && newX<grid.length &&
                newY >=0 && newY<grid[0].length &&
                    grid[newX][newY] == 1){   
                        grid[newX][newY] =2;                     
                        sum += dfs(newX , newY , grid);
            }
        }
        return sum;
    }
}
