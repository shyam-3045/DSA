class Solution {
    class Pair{
        int fir;
        int sec;
        int len;

        Pair(int fir, int sec, int len)
        {
            this.fir=fir;
            this.sec=sec;
            this.len=len;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] !=0 || grid[n-1][n-1] !=0) return -1;
        
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][n];

        q.offer(new Pair(0,0,1));
        vis[0][0]=1;


        while(!q.isEmpty())
        {
            int row = q.peek().fir;
            int col = q.peek().sec;
            int len = q.peek().len;
            q.poll();

            if(row == n-1 && col == n-1) return len;
            for(int dx = -1 ;dx <=1;dx++)
            {
                for(int dy =-1;dy<=1;dy++)
                {
                    int nrow = row+dx;
                    int ncol = col+dy;

                    

                    if(nrow >= 0 && ncol >= 0 && nrow < n && ncol <n && grid[nrow][ncol] ==0 && vis[nrow][ncol] == 0)
                    {

                        
                        
                            q.offer(new Pair(nrow,ncol,len+1));
                            vis[nrow][ncol]=1;
                        
                        

                    }
                }
                
            }

        }

        return -1;
    }
}