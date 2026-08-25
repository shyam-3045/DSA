class Solution {
    private int fn(int amt , int[] coins,int n,int[][] dp)
    {
        if(amt == 0 )return 1;
        if(n==0)
        {
            if(amt % coins[n] == 0)return 1;
            return 0;
        }
        if(dp[n][amt] != -1) return dp[n][amt];
        int notTake = fn(amt,coins,n-1,dp);
        int take=0;
        if(coins[n] <= amt) take=fn(amt - coins[n],coins,n,dp);

        return dp[n][amt]=notTake+take;


    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        return fn(amount,coins,coins.length-1,dp);
    }
}