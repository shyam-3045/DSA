import java.util.*;
class Solution {
    public int maxProfit(int[] p) {
       int l=0;
       int r=l+1;
       int pro =0;

       while(r<p.length){
        if(p[r] - p[l] <=0)
        {
            l=r;
        }
        if(p[r]-p[l] > 0)
        {
            pro = Math.max(pro,p[r]-p[l]);
            
        }
        r++;
       }

       return pro;
       
    }
}