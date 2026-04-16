class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return getCount(nums,k) - getCount(nums,k-1);
    }

    private int getCount(int[] nums,int k)
    {
        if (k < 0)
        {
            return 0;
        }

        int n=nums.length;
        int l=0;
        int r=0;
        int count =0;
        int sum=0;

        for(int i=0;i <n;i++)
        {
            nums[i]=nums[i] % 2;
        }

        while (r < n)
        {
            sum +=nums[r];
            while (sum > k)
            {
                sum -= nums[l];
                l++;
            }

            int len = r-l+1;
            count +=len;
            r++;
        }
         return count;
        
        }
    }
