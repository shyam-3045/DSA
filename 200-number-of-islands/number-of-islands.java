class Solution {
    private void dfs(char[][] grid , int[][] vis , int i,int j)
    {
        int n = grid.length;
        int m = grid[0].length;
        vis[i][j] =1;

        int[] delrow = {-1,0,1,0};
        int[] delcol= {0,1,0,-1};

        for(int k=0;k<4;k++)
        {
            int r = delrow[k] + i;
            int c = delcol[k] + j ;

            if(r >=0  && r <n && c>=0 && c < m && grid[r][c] == '1' && vis[r][c] == 0)
            {
                dfs(grid,vis,r,c);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt =0;

        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == '1' && vis[i][j] == 0 )
                {
                    cnt++;
                    dfs(grid,vis,i,j);
                }
            }
        }

        return cnt;

    }
}