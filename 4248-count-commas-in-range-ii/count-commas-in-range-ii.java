class Solution {
    public long countCommas(long n) {
        if(n < 1000) return 0;
        long x =1000 , ans =0;

        while(x <=n)
        {
            ans+= (n-x)+1;
            x*=1000;
        }

        return ans;
    }
}