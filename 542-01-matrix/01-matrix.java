class Solution {
    class Pair {
        int fir;
        int sec;
        int dis;

        Pair(int fir , int sec , int dis)
        {
            this.fir=fir;
            this.sec=sec;
            this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        int[][] vis = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0)
                {
                    q.offer(new Pair(i,j,0));
                    vis[i][j] =1;
                }else{
                    ans[i][j] =0;
                }
            }
        }

        int[] delrow={-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        while(!q.isEmpty()){
            int r =q.peek().fir;
            int c = q.peek().sec;
            int d = q.peek().dis;

            q.poll();
            ans[r][c] = d;
            

            for(int i=0;i<4;i++)
            {
                int nrow=r+delrow[i];
                int ncol = c+delcol[i];

                if(nrow >=0 && nrow < n && ncol >=0 && ncol <m && vis[nrow][ncol] == 0)
                {
                     
                    vis[nrow][ncol]=1;
                    q.offer(new Pair(nrow,ncol,d+1));
                    
                }
                


            }
        }


        return ans;


    }
}