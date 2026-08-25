class Solution {
    private int fn(int n,int m , String text1 , String text2,int[][] dp)
    {
        if(n < 0 || m < 0) return 0;

        if(dp[n][m] != -1) return dp[n][m];
        if(text1.charAt(n) == (text2.charAt(m)))
        {
            return dp[n][m]=1+fn(n-1,m-1,text1,text2,dp);
        }
        int fir = fn(n-1,m,text1,text2,dp) ;
        int sec = fn(n,m-1,text1,text2,dp);
        
        return dp[n][m] =Math.max(fir,sec);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
         return fn(text1.length()-1,text2.length()-1,text1,text2,dp);
    }
}