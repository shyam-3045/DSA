class Solution {
    public int smallestNumber(int n, int t) {
       int ans =0;
        for(int i = n ;i<101;i++)
        {
            int j=i;
            int pro = 1;
            while(j!=0){
                int x = j % 10;
                pro*=x;
                j=j/10;
            }
            if(pro % t == 0 || pro == 0){
                ans = i;
                break;
            }
        }

        return ans;
    }
}