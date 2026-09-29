class Solution {
    class Pair {
        int r;
        int c;

        Pair(int r, int c)
        {
            this.r =r;
            this.c=c;
        }
    }

    private void bfs(char[][] grid ,int row,int col , int[][] vis)
    {
        Queue<Pair> q = new LinkedList<>();
        vis[row][col]=1;
        q.offer(new Pair(row,col));

        while(!q.isEmpty())
        {
            int r = q.peek().r;
            int c =q.peek().c;
            q.poll();
            int[] dr ={-1,0,1,0};
            int[] dc ={0,1,0,-1};

            for(int k=0;k<4;k++)
            {
                int drow = r+dr[k];
                int dcol = c+dc[k];

                if(dcol >= 0 && dcol < grid[0].length && drow >=0 && drow < grid.length && vis[drow][dcol] == 0 && grid[drow][dcol] == '1'){
                    bfs(grid,drow,dcol,vis);
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
       int c=0;
       int row = grid.length;
       int col = grid[0].length;
       int[][] vis = new int[row][col];

       for(int i=0;i<row;i++)
       {
        for(int j=0;j<col;j++)
        {
            if(grid[i][j] == '1' && vis[i][j] ==0)
            {
                c++;
                bfs(grid,i,j,vis);
            }
        }
       }

       return c;
    }




}