class Solution {
    private int fn(int[] nums, int i,int prev,int[][] dp){

        if(i<0) return 0;

        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int notTake =fn(nums,i-1,prev,dp);

        int take =0;
        if(prev == -1 || nums[i] < nums[prev])
        {
            take = 1+fn(nums,i-1,i,dp);
        } 

        return dp[i][prev+1]=Math.max(take,notTake);

    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return fn(nums ,nums.length-1,-1,dp);
        
    }
}