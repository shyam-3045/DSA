class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
       int[] prefix = new int[n];
       int[] postfix =new int[n];
       int[] ans = new int[n];
       int sum =0;

       for(int i=0;i<n;i++){
         prefix[i]=sum;
         sum+=nums[i];
       }

       sum=0;
       for(int i=n-1;i>=0;i--){
         postfix[i]=sum;
         sum+=nums[i];
       }

       for(int i=0;i<n;i++){
        int val = Math.abs(prefix[i] - postfix[i]);
        ans[i] = val;
       }
       return ans;
    }
}