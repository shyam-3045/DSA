import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
       int l=0;
       int r=l+1;
       int profit=0;

       while (r < n)
       {
        if( prices[r]-prices[l] <= 0)
        {
            l = r;
        }
        if ( prices[r]-prices[l] > 0)
        {
            profit = Math.max(profit , prices[r]-prices[l]);
            r++;
            continue;
        }
        r++;

       } 
       return profit;
       
    }
}