import java.util.*;
class Solution {
    public int maxProfit(int[] p) {
       int buy = Integer.MAX_VALUE;
       int pro =0;
       for(int s : p)
       {
        if(s < buy) buy =s;
        else{
            pro = Math.max(pro,s-buy);
        }

        
       }

       return pro;
       
    }
}