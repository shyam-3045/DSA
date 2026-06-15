class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans =0;
        int p = cost.length-1;
        int c=0;
        while(p >= 0)
        {
            if(c<2){
                ans+=cost[p];
                c++;
                p--;
                
            }
            else{
                c=0;
                p-=1;
            }  

        }

        return ans;
    }
}