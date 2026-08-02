import java.util.*;
class Solution {
    public int maxProfit(int[] p) {
       int l=0;
       int r=l+1;
       int profit=0;

        while(r< p.length)
        {
            if(p[r] - p[l] <=0)
            {
                l=r;
            }
            if(p[r] - p[l] >0)
            {
                profit= Math.max(profit , p[r]-p[l]);
                r++;
                continue;
            }
            r++;
        }


       return profit;
       
    }
}