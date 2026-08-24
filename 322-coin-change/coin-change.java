class Solution {
    private int fn(int[] coins , int amt , int n,int[][] dp)
    {
        if(amt == 0) return 0;
        if(n == 0)
        {
            if(amt % coins[n] == 0) return amt / coins[n];
            return Integer.MAX_VALUE /2;
        }
        if(dp[n][amt] != -1) return dp[n][amt];
        int notTake = 0+fn(coins,amt,n-1,dp);
        int take = Integer.MAX_VALUE /2;
        if(coins[n] <= amt)
        {
            take = 1+fn(coins,amt - coins[n],n,dp);
        }
        return dp[n][amt]= Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[][] dp = new int[coins.length][amount+1];
        // for(int[] row: dp)
        // {
        //     Arrays.fill(row,-1);
        // }
        // int ans =  fn(coins,amount,coins.length-1,dp);
        // return ans >= Integer.MAX_VALUE /2 ? -1: ans;
        for(int i=0;i<=amount;i++)
        {
            if(i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = Integer.MAX_VALUE /2 ;
        }

        for(int i=1;i<coins.length;i++)
        {
            for(int tar = 0;tar<=amount;tar++)
            {
                int notTake = 0+dp[i-1][tar];
                int take = Integer.MAX_VALUE /2;
                if(coins[i] <= tar) take = 1+dp[i][tar -coins[i]];
                dp[i][tar] = Math.min(take,notTake);
            }
        }
        return dp[coins.length-1][amount] >= Integer.MAX_VALUE /2 ? -1 : dp[coins.length-1][amount] ;
    }
}