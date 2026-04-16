class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return getCount(nums,goal) - getCount(nums,goal-1);
    }
    private int getCount(int[] nums,int goal)
    {
        if(goal <0)
        {
            return 0;
        }
        int n = nums.length ;
        int r=0;
        int count =0;
        int sum=0;
        int l=0;
        while (r<n)
        {
            sum +=nums[r];
            
            while(sum > goal)
            {
                sum -= nums[l];
                l++;
            }
            int len = r-l+1;
            count += len;
            r++;
        }
        return count;
    }
}