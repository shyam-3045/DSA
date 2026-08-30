class Solution {
    private boolean fn(int[] arr , int m , int dis)
    {
        int curr = 1;
        int last = arr[0];

        for(int i=1;i<arr.length;i++)
        {
            if(arr[i] - last >= dis)
            {
                curr ++;
                last = arr[i];
            } 
        }

        return curr >= m ?true:false;
    }
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int l=1,r=arr[arr.length -1]- arr[0];

        while(l <=r)
        {
            int mid = l + (r-l)/2;
            if(fn(arr,m,mid))
            {
                l = mid+1;
            }
            else r=mid-1;
        }

        return r;
    }
}