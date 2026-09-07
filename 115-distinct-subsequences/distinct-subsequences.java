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
        int[][] dp = new int[s.length()][t.length()];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return fn(s,t,s.length()-1,t.length()-1,dp);
    }
}