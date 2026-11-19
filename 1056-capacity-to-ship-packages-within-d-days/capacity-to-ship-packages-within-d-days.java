class Solution {
    private boolean fn(int[] arr , int days,int cap)
    {
        int c =0 , cnt=1;

        for(int i =0;i<arr.length;i++)
        {
            if(c+arr[i] > cap){
                cnt++;
                c=0;
            }
            c+=arr[i];
        }

        return cnt <= days;


    }
    public int shipWithinDays(int[] arr, int days) {
        int sum =0 ,max =0;
        for(int a : arr)
        {
            max=Math.max(a,max);
            sum+=a;
        }
        int l =max , r =sum ;

        while(l <=r)
        {
            int mid = l +(r - l)/2;
            if(fn(arr,days,mid)) r=mid-1;
            else l=mid+1;
        }

        return l;
    }
}