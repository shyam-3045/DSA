class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0 , r=0;
        int max =0;
        int cnt =0;
        int temp =0;
        while(r <nums.length)
        {
            if(nums[r] ==1 ) cnt++;
            else if(nums[r] == 0 && temp <= k) {
                cnt++;
                temp++;
            } 

            while(temp > k)
            {
                if(nums[l] == 1){
                    l++;
                    continue;
                }
                temp --;
                cnt= 0;
                l++;
            }

            max=Math.max(max,r-l+1);
            r++;

        }

        return max;
    }

}