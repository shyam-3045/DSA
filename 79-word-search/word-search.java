class Solution {

    private boolean dfs(char[][] grid , int[][] vis ,StringBuilder st,String word, int n , int m , int i , int j)
    {
        vis[i][j] =1;
        st.append(grid[i][j]);
        if (st.charAt(st.length()-1) != word.charAt(st.length()-1)) {
            st.deleteCharAt(st.length()-1);
            vis[i][j] = 0;
            return false;
        }
        if(st.toString().equals(word)) return true;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        for(int k=0;k<4;k++)
        {
            int drow = i+delrow[k];
            int dcol = j+delcol[k];
            if(drow>=0 && drow < n && dcol >=0 && dcol < m && vis[drow][dcol] == 0 )
            {
                if(dfs(grid,vis,st,word ,n, m,drow,dcol)) return true ;
            }
        }
        st.deleteCharAt(st.length()-1);
        vis[i][j]=0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n= board.length;
        int m=board[0].length;
        StringBuilder st = new StringBuilder();
        int[][] vis = new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j] == 0)
                {
                    if(dfs(board , vis , st,word,n, m,i,j)) return true;
                }
            }
        }

        return false;
    }
}