class Solution {
    public long gcdSum(int[] nums) {
        int[] arr = new int[nums.length]; 
        int max  = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            arr[i] = getGcd(nums[i], max);
        }


        Arrays.sort(arr);

        long ans = 0;

        int l=0;
        int r=arr.length-1;

        while(l < r){
            ans += getGcd(arr[l],arr[r]);
            l++;
            r--;
        }

        return ans;
    }

    private int getGcd(int a , int b){
        while (b !=0)
        {
            int temp = b;
            b= a%b;
            a=temp;
        }

        return Math.abs(a) ;
    }
}