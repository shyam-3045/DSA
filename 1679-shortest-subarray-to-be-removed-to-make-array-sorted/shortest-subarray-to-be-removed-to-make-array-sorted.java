class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left =0 , right=arr.length-1;

        while(left +1 < arr.length && arr[left] <= arr[left+1])
        {
            left++;
        }

        if(left == arr.length -1) return 0;

        while(right > 0 && arr[right] >= arr[right-1])
        {
            right--;
        }

        int ans = Math.min(arr.length - left -1 , right);


        int i=0;
        int j=right;

        while(i <= left && j < arr.length )
        {
            if(arr[i] <= arr[j])
            {
                ans=Math.min(ans,j-1-i);
                i++;
            }
            else j++;
        }
        return ans;


    }
}