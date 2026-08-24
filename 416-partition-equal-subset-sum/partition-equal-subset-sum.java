class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length ;
        int sum = 0;
        for(int num:nums)
        {
            sum+=num;
        }
        if(sum%2 == 1) return false;

        int tar = sum/2;
        boolean[][] dp = new boolean[n][tar+1] ;

        for(int i=0;i<n;i++)
        {
            dp[i][0]=true;
        }
        if(nums[0] <= tar)dp[0][nums[0]] = true;

        for(int i=1;i<n;i++)
        {
            for(int target = 1 ; target <= tar ;target ++)
            {
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(nums[i] < target) take = dp[i-1][target - nums[i]];

                dp[i][target] = take || notTake;
                
            }
        }

        return dp[n-1][tar];
        
    }
}