class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n= nums.length;
        int max=0;
        int l=0;
        int r=0;

        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.get(nums[r]) > k)
            {
                map.put(nums[l],map.getOrDefault(nums[l],0)-1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);

                l++;
            }
            max=Math.max(max, r-l+1);
            r++;
        }

        return max;

    }
}