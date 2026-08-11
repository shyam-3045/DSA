class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long sum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            map.put(nums[i] , map.getOrDefault(nums[i],0)+1);

            if(i >= k)
            {
                int out = nums[i-k];
                sum-=out;
                map.put(out,map.get(out) -1);
                if(map.get(out) == 0)
                {
                    map.remove(out);
                }
            }

            if(map.size() == k)
            {
                max = Math.max(max,sum);
            }

        }

        return max;

    }
}