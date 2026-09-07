class Solution {
    private int fn(String s , String t, int i , int j,int[][] dp)
    {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int take = 0;
        if(s.charAt(i) == t.charAt(j) ) take = fn(s,t,i-1,j-1,dp);
        int notTake = fn(s,t,i-1,j,dp);

        return dp[i][j] =take+notTake;
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        // for(int[] row : dp)
        // {
        //     Arrays.fill(row,-1);
        // }
        // return fn(s,t,s.length()-1,t.length()-1,dp);
        dp[0][0]=1;

        for(int i=1;i<=s.length();i++)
        {
            dp[i][0] = 1;
        }

        for(int i=1;i<=t.length();i++)
        {
            dp[0][i]=0;
        }

        for(int i=1;i<=s.length();i++)
        {
            for(int j=1;j<=t.length();j++)
            {
                int take = 0;
                if(s.charAt(i-1) == t.charAt(j-1) ) take = dp[i-1][j-1];
                 int notTake = dp[i-1][j];

                 dp[i][j]=take+notTake;


            }
        }

        return dp[s.length()][t.length()];
    }
}