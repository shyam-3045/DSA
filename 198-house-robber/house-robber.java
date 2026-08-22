class Solution {

    private int fn(int[] nums , int i ,int[] dp)
    {
        if(i==0) return nums[i];
        if(i <0)return 0;

        if(dp[i] != -1) return dp[i];

        int fir = nums[i]+fn(nums,i-2,dp);
        int sec = 0+fn(nums,i-1,dp);
        return dp[i]=Math.max(fir,sec);
    }
    public int rob(int[] nums) {
       int[] dp = new int[nums.length +1];
       Arrays.fill(dp ,-1);
       return fn(nums ,nums.length -1,dp); 
    }
}