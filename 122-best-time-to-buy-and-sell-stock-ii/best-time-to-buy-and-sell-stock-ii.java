class Solution {
    public int maxProfit(int[] a) {
      int n = a.length;
      int profit =0;
      for(int i=0;i<n-1;i++)
      {
        if(a[i] < a[i+1])
        {
            profit+=a[i+1] - a[i];
        }
      }
    return profit;
}
}