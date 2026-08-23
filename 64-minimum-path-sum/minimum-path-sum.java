class Solution {

    private int fn(int[][] grid , int i,int j,int[][] dp)
    {
        if(i<0 || j<0) return 1_000_000_000;
        if(i==0 && j==0) return grid[i][j];

        if(dp[i][j] !=-1) return dp[i][j];


        int left =grid[i][j]+fn(grid,i,j-1,dp);
        int up =grid[i][j] + fn(grid,i-1,j,dp);

        return dp[i][j]=Math.min(left,up);
    }

    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
       int[][] dp =new int[m][n];
    //    for(int[] row:dp)
    //    {
    //      Arrays.fill(row,-1);
    //    } 

       //return fn(grid,grid.length-1,grid[0].length-1,dp);

       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
            if(i==0 && j==0) {
                dp[i][j] =grid[i][j];
                continue;
            }
            else{
                int up =1_000_000_000;
                int left = 1_000_000_000;
                if(i>0) up = grid[i][j] +dp[i-1][j];
                if(j>0) left = grid[i][j]+dp[i][j-1];
                dp[i][j] = Math.min(up,left);


            }
            
        }
       }

       return dp[m-1][n-1];
    }
}