class Solution {
    public int subarraySum(int[] nums, int k) {
        return solve(nums, k, 0);
    }

    private int solve(int[] nums, int k, int start) {
        if (start == nums.length) {
            return 0;
        }

        int sum = 0;
        int count = 0;

        for (int i = start; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                count++;
            }
        }

        return count + solve(nums, k, start + 1);
    }
}