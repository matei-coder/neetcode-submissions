class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        final int[] dx = {-1 , 1 , 0 , 0};
        final int[] dy = {0 , 0, -1 , 1};
        for(int i=0;i<m;i++){
            if(board[0][i] == 'O')
            q.add(new int[]{0 , i});
            if(board[n-1][i] == 'O')
            q.add(new int[]{n-1 , i});
        }
        for(int i=0;i<n;i++){
            if(board[i][0] == 'O')
            q.add(new int[]{i , 0});
            if(board[i][m-1] == 'O')
            q.add(new int[]{i , m-1});
        }
        int[][] boardCopy = new int[n][m];

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            boardCopy[x][y] = 1;
            for(int i=0;i<4;i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX >=0 && newX < n &&
                    newY >=0 && newY < m 
                    && board[newX][newY] == 'O' && boardCopy[newX][newY] == 0){
                        q.add(new int[]{newX , newY});

                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(boardCopy[i][j] == 1){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }


    }
}
