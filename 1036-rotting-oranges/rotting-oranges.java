class Solution {
    class Pair{
        int fir ;
        int sec ;
        int tm;

        Pair(int first , int sec,int time){
            this.fir = first;
            this.sec = sec ;
            this.tm =time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cntFresh = 0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2)
                {
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else vis[i][j] = 0;
                if(grid[i][j] == 1) cntFresh++;
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol={0,1,0,-1};
        int cnt =0;
        int tm =0;
        
        while(!q.isEmpty()){
            int r = q.peek().fir;
            int c = q.peek().sec;
            int t = q.peek().tm;
            tm = Math.max(tm,t);
            q.poll();
            for(int i=0;i<4;i++)
            {
                int ncol = c+delCol[i];
                int nrow = r +delRow[i];

                if(ncol >= 0 && ncol < m && nrow >=0 && nrow < n && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1){
                    q.offer(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }

            
        }
        if(cnt != cntFresh) return -1;
        return tm;

        
    }
}