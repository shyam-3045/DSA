class Solution {
    // private int fn(int[] dp , int n)
    // {
    //     if(n == 0) return 1;
    //     if(n<0) return 0;
    //     if(dp [n] != -1) return dp[n];

    //     int l = fn(dp,n-1);
    //     int r = 0;
    //     if(n > 1) {
    //         r = fn(dp,n-2);
    //     }

    //     return dp[n] = l+r;
    // }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;

        for(int i=1;i<=n;i++)
        {
            int l = dp[i-1];
            int r=0;
            if(i > 1) r= dp[i-2];
            dp[i]=l+r;
        }
        return dp[n];
    }
}