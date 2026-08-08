class Solution {
    private void dfs(int[] delRow , int[] delCol , int[][] vis , char[][] grid , int r , int c){
        vis[r][c]=1;
        int n=grid.length;
        int m=grid[0].length;

        for(int k=0;k<4;k++)
        {
            int ncol = c + delCol[k];
            int nrow = r + delRow[k];

            if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 'O')
            {
                dfs(delRow,delCol,vis,grid,nrow,ncol);
            }


        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};

        int[][] vis =  new int[n][m];

        for(int i=0;i<m;i++)
        {
            if(board[0][i] == 'O' && vis[0][i] == 0)
            {
                dfs(delRow,delCol,vis,board,0,i);

            }
            if(board[n-1][i] == 'O' && vis[n-1][i] == 0)
            {
                dfs(delRow,delCol,vis,board,n-1,i);

            }

        }

        for(int i=0;i<n;i++)
        {
            if(board[i][0] == 'O' && vis[i][0] == 0)
            {
                dfs(delRow,delCol,vis,board,i,0);

            }
            if(board[i][m-1] == 'O' && vis[i][m-1] == 0)
            {
                dfs(delRow,delCol,vis,board,i,m-1);

            }

        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j] == 0 && board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
            }
        }
    }
}