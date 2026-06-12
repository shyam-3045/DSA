class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] res =new int[nums.length];
        int n = nums.length;
    
        for(int i=0;i<nums.length;i++){
            int idx = ((i+nums[i]) % n + n)%n;
            res[i] = nums[idx];

        }  

        return res ;
    }
}