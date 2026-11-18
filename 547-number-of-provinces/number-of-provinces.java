class Solution {
    private void dfs(int[][] grid , int[] vis , int n )
    {
        vis[n] = 1;
        for(int i=0;i<grid.length;i++)
        {
            if(grid[n][i] == 1 &&vis[i]== 0){
                dfs(grid,vis,i);
            }
        }
    }
    {
        
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] vis = new int[n];
        int cnt =0;

        for(int i =0;i<n;i++)
        {
            if(vis[i] == 0)
            {
                cnt++;
                dfs(isConnected , vis,i);
            }
        }
        return cnt;

    }
}