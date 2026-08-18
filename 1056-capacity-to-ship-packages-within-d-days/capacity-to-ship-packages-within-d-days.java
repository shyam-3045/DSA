class Solution {

    private int findDay(int[] w , int d)
    {
        int day = 1 , load= 0;
        for(int i=0;i<w.length;i++)
        {
            if(load + w[i] > d){
                day++;
                load = w[i];
            }
            else load+=w[i];
        }

        return day;
    }
    public int shipWithinDays(int[] w, int days) {
        int cap = 0 , sum =0;
        for(int i=0;i<w.length;i++)
        {
            cap = Math.max(cap , w[i]);
            sum+=w[i];
        }

        int l=cap;
        int r=sum;
        while(l < r)
        {
            int mid = l + (r -l)/2;

            int day = findDay(w,mid);
            if(day > days) l = mid +1;
            else r =mid ;
        }

        return l ;
    }
}