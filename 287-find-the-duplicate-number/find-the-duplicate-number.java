class Solution {
    public int findDuplicate(int[] nums) {
        int l =1;
        int r = nums.length -1;

        while(l < r)
        {
            int mid = l + (r-l) /2;
            int c =0;
            for(int n: nums)
            {
                if(n <= mid) c++;
            }

            if(c > mid)
            {
                r = mid;
            }
            else {
                l = mid+1;
            }
        }

        return l;
    }
}