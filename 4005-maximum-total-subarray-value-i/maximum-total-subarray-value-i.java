class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min =Integer.MAX_VALUE;
        int max =Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i] >max ){
                max=nums[i];
            }
            if(nums[i] < min){
                min=nums[i];
            }
        }
        long ans =0;

        for(int i=0;i<k;i++ ){
            ans+=max-min;
        }

        return ans;
    }
}