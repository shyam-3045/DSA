class Solution {

    private void dfs(int r , int c , int[][] grid , int[][] vis , int[] delRow,int[] delCol)
    {
        int n = grid.length;
        int m = grid[0].length;

        vis[r][c]=1;

        for(int i=0;i<4;i++)
        {
            int ncol = c + delCol[i];
            int nrow = r + delRow[i];

            if(ncol >=0 && nrow >=0 && ncol < m && nrow < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1)
            {
                dfs(nrow,ncol,grid,vis,delRow,delCol);
            }
        }
    }
    {

    }
    public int numEnclaves(int[][] grid) {
       int n = grid.length;
       int m= grid[0].length;

       int[][] vis = new int[n][m];
       int[] delRow = {-1,0,1,0};
       int[] delCol = {0,-1,0,1};

       for(int i =0;i<m;i++ ){
        if(vis[0][i] == 0 && grid[0][i] == 1)
        {
            dfs(0,i,grid,vis,delRow,delCol);

        }
        if(vis[n-1][i] == 0 && grid[n-1][i] == 1)
        {
            dfs(n-1,i,grid,vis,delRow,delCol);
            
        }
       }

       for(int i =0;i<n;i++ ){
        if(vis[i][0] == 0 && grid[i][0] == 1)
        {
            dfs(i,0,grid,vis,delRow,delCol);

        }
        if(vis[i][m-1] == 0 && grid[i][m-1] == 1)
        {
            dfs(i,m-1,grid,vis,delRow,delCol);
            
        }
       }

       int cnt = 0;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++)
        {
            if(vis[i][j] == 0 && grid[i][j] == 1)
            {
                cnt++;
            }
        }
       }

       return cnt;


    }
}