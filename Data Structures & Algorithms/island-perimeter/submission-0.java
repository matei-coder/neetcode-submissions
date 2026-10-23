class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;

        int[] dx = {-1 , 1 , 0 , 0};
        int[] dy = {0 , 0 , -1 , 1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    int neighbours = 0;
                    for(int k=0;k<4;k++){
                        if(i+dx[k]>=0 && i+dx[k] < n
                        && j+dy[k]>=0 && j+dy[k]<m &&
                        grid[i+dx[k]][j+dy[k]] == 1){
                            neighbours++;
                        }
                    }
                    ans+= 4-neighbours;

                }
            }
        }

        return ans;
    }
}