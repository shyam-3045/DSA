class Solution {
    private void swap(int[] a , int i , int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void reverse(int[] a , int l , int r)
    {
        while(l < r)
        {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++;
            r--;
        }
    }
    public void nextPermutation(int[] nums) {
         int i = nums.length -1;

         while(i > 0 && nums[i] <= nums[i-1]) 
         {
            i--;
         }

         if(i == 0)
         {
            reverse(nums , 0 , nums.length -1);
            return ;
         }

         int j =nums.length -1;

         while(nums[j] <= nums[i-1])
         {
            j--;
         }

         swap(nums,i-1,j);
         reverse(nums,i,nums.length-1);
    }
}