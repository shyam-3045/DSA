class Solution {
    private int fn(String s ,String p , int n, int m,int[][] dp)
    {
        if(n == 0)return m;
        if(m == 0)return n;
        if(dp[n][m] != -1)return dp[n][m];

        if(s.charAt(n-1) == p.charAt(m-1)) return dp[n][m]=0+fn(s,p,n-1,m-1,dp);

        return dp[n][m]= Math.min(1+fn(s,p,n-1,m,dp) , Math.min(1+fn(s,p,n,m-1,dp) ,1+fn(s,p,n-1,m-1,dp)));
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return fn(word1,word2,word1.length(),word2.length(),dp);
         
    }
}