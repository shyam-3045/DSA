class Solution {
    int maxArea = 0;
    int cnt=0;

    private void dfs(int[][] grid, int[][] vis, int n, int m, int i, int j) {

        vis[i][j] = 1;
        cnt++;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {

            int drow = i + delrow[k];
            int dcol = j + delcol[k];

            if (drow >= 0 && drow < n &&
                dcol >= 0 && dcol < m &&
                grid[drow][dcol] == 1 &&
                vis[drow][dcol] == 0) {

                dfs(grid, vis, n, m, drow, dcol);
            }
        }

        maxArea = Math.max(maxArea,cnt);
        return ;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && vis[i][j] == 0) {

                    cnt=0;
                    dfs(grid, vis, n, m, i, j);

                }
            }
        }

        return maxArea;
    }
}
