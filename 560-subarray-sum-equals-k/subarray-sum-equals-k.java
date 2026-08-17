class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int pre=0;
        int cnt=0;

        for(int i=0;i<nums.length;i++)
        {
            pre += nums[i];
            int sum= pre - k;
            cnt+= map.getOrDefault(sum,0);
            map.put(pre , map.getOrDefault(pre ,0)+1);


        }
        return cnt;
    }

    
}