class Solution {
    class Pair{
        int a;
        int b;
        int d;

        Pair(int a,int b ,int d){
            this.a =a;
            this.b=b;
            this.d=d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n =mat.length;
        int m= mat[0].length;
        Queue <Pair> q = new LinkedList<>();
        int[][] vis= new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j] == 0)
                {
                    q.offer(new Pair(i,j,0));
                }
            }
        }

        int[] delrow = {-1,0,1,0};
        int[] delcol ={0,1,0,-1};

        while(!q.isEmpty()){
            int r=q.peek().a;
            int c=q.peek().b;
            int dis = q.peek().d;

            for(int k=0;k<4;k++)
            {
                int nrow =r+delrow[k];
                int ncol = c+delcol[k];
                if(nrow >=0 && ncol >=0 && nrow < n&& ncol < m && mat[nrow][ncol] == 1 && vis[nrow][ncol] == 0)
                {
                    mat[nrow][ncol]=dis+1;
                    q.offer(new Pair(nrow,ncol,dis+1));
                    vis[nrow][ncol] =1;
                }
                
            }
            q.poll();
        }

        return mat;

        
    }
}