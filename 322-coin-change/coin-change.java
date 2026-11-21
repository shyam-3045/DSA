class Solution {
    private int fn(int[] arr,int[][] dp , int amt , int n)
    {
        if(n == 0) {
            if(amt % arr[n] == 0) return amt / arr[n] ;
            else return Integer.MAX_VALUE /2;
        }
        if(amt == 0)return 0;
        if(dp[n][amt] != -1) return dp[n][amt];
        int take = Integer.MAX_VALUE /2;
        if(arr[n] <= amt)
        {
            take = 1+fn(arr,dp,amt-arr[n],n);
        }
        int notTake = fn(arr,dp, amt,n-1);

        return dp[n][amt] =Math.min(take , notTake);
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[][] dp = new int[coins.length][amount+1];
        for(int[] d: dp)
        {
            Arrays.fill(d,-1);
        }
        int val = fn(coins,dp , amount , coins.length-1);


        return val >= Integer.MAX_VALUE /2 ?-1:val;
    }
}