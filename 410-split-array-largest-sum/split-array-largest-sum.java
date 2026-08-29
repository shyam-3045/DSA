class Solution {
    // private int fn(int[] nums,int k,int[] pre,int n,int[][] dp)
    // {
    //     if(k==1) return pre[n]+nums[n];
    //     if(dp[n][k] != -1) return dp[n][k];

    //     int ans=Integer.MAX_VALUE;
    //     for(int i=k-1;i<=n;i++)
    //     {
    //         int left = fn(nums,k-1,pre,i-1,dp);
    //         int right = pre[n] + nums[n] - pre[i];
    //         int lar = Math.max(left,right);
    //         ans = Math.min(ans,lar);
    //     }
    //     return dp[n][k]=ans ;
    // }
    public int splitArray(int[] nums, int k) {
        // int[] prefix = new int[nums.length];
        // int pre =0 ,sum=0;

        // for(int i=0;i<nums.length;i++)
        // {
        //     prefix[i] =pre;
        //     pre+=nums[i];
        //     sum+=nums[i];
        // }
        // int[][] dp = new int[nums.length][k+1];
        // for(int[] row:dp)
        // {
        //     Arrays.fill(row,-1);
        // }

        // return fn(nums,k,prefix,nums.length-1,dp);
        int low =0 ,high =0;

        for(int n : nums)
        {
            low=Math.max(low,n);
            high+=n;
        }

        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int val = fn(nums,mid);
            if(val > k) low = mid+1;
            else high =mid-1;
        }

        return low;


    }

    private int fn(int[] arr , int val)
    {
        int max = 1 , curr =0;

        for(int n:arr)
        {
            if(curr + n <= val) curr+=n;
            else
            {
                max++;
                curr =n;
            }
        }

        return max;
    }
}