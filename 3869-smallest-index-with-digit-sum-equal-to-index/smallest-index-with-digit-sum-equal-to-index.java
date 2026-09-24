class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
                          
                int t = nums[i];
                int sum =0;
                while(t!=0)
                {
                    sum+= t%10;
                    t=t/10;
                }
                if(sum == i) return i;
            
           
        }
        return -1;
    }
}