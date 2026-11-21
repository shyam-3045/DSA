class Solution {
    private int fn(int[] arr,int[] dp , int n)
    {
        if(n == 0 ) return arr[0];
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        int take = arr[n]+fn(arr,dp,n-2);
        int notTake = fn(arr,dp,n-1);

        return dp[n]=Math.max(take,notTake);

    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length +1];
        Arrays.fill(dp,-1);
        return fn(nums,dp , nums.length-1);
    }
}