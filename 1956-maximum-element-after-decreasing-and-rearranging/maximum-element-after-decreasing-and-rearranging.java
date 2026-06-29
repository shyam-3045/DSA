class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
      Arrays.sort(arr);
      int ans =0;
      for(int i=0;i<arr.length;i++){
        ans = Math.min(ans+1 , arr[i]); 
      }

      return ans ;

    }
}