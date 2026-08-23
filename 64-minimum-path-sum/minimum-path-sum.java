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
       int[][] dp =new int[grid.length][grid[0].length];
       for(int[] row:dp)
       {
         Arrays.fill(row,-1);
       } 

       return fn(grid,grid.length-1,grid[0].length-1,dp);
    }
}