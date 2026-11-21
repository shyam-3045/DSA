class Solution {
    private int fn(int[] dp , int n)
    {
        if(n == 0) return 1;
        if(n<0) return 0;
        if(dp [n] != -1) return dp[n];

        int l = fn(dp,n-1);
        int r = 0;
        if(n > 1) {
            r = fn(dp,n-2);
        }

        return dp[n] = l+r;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fn(dp ,n);
    }
}