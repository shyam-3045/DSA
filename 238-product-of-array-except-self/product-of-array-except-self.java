class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pre =1;
        int i=0;

        for(int n : nums)
        {
            res[i++]=pre ;
            pre *=n;
        }

        int pos=1;

        for(i=nums.length-1;i>=0;i--)
        {
            res[i] *= pos;
            pos *= nums[i
            ];
        }

        return res;
    }
}