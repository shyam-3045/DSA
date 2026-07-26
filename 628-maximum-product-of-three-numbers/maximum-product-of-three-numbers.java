class Solution {
    public int maximumProduct(int[] nums) {
        // int max1 =0 , max2=0 , max3=0;
        // boolean sign =false; 

        // for(int n : nums)
        // {
        //     sign = n>0 ? false : !sign ;
        //     int v = Math.abs(n);
        //     if(v > max1)
        //     {
        //         max3=max2;
        //         max2=max1;
        //         max1=v;
        //     }
        //     else if(v > max2){
        //         max3=max2;
        //         max2=v;
        //     }
        //     else if(v > max3){
        //         max3=v;
        //     }
        // }
        // int res = max1 * max2 * max3 ;

        // return sign == false ? res : res * -1 ;

        
        Arrays.sort(nums);
        int ans =Integer.MIN_VALUE;
        int x = nums[nums.length -1] * nums[nums.length -2] *nums[nums.length -3];
        ans = Math.max(x,ans);
        x = nums[0] * nums[1] * nums[nums.length -1];
        ans = Math.max(x, ans);
        return ans ;
    }
}