class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length ;
        int maxPile =0;

        for(int i=0;i<n;i++)
        {
            if(piles[i] > maxPile)
            {
                maxPile=piles[i];
            }
        }
        int low =1;
        int high = maxPile;

        while (low <= high)
        {
            int mid = low+(high - low)/2;
            int totalHours = findTotalHours(piles , mid);
            if(totalHours <= h)
            {
                
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low ;
    }

    private int findTotalHours(int[] a,int hr)
        {
            int totalHours = 0;

            for(int i=0;i<a.length;i++)
            {
                totalHours += Math.ceil((a[i] + hr - 1) / hr);
            }

            return totalHours ;
        }
}