class Solution {

    private static int fn(int[] nums , int  i, int[] dp,int st)
    {
        if(i <st ) return 0;
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + fn(nums,i-2,dp,st);
        int sec=0+fn(nums,i-1,dp,st);
        return dp[i] = Math.max(take,sec);

    }
    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length +1];
        int[] dp2 = new int[nums.length +1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int fir = fn(nums,nums.length -1,dp1,1);
        int sec = fn(nums,nums.length -2 ,dp2,0);
        return Math.max(fir,sec);
    }
}