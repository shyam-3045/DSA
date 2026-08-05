class Solution {
    class Pair{
        int first;
        int sec ;

        Pair(int first , int sec){
            this.first = first;
            this.sec= sec;
        }
    }
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int cnt =0;


        int[][] vis = new int[row][col];
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    bfs(j,i,grid,vis);
                    cnt++;
                }
            
        }
        }

        return cnt;
    }

    private void bfs(int col , int row , char[][] grid , int[][] vis){
        Queue<Pair> q = new LinkedList<Pair>();
        vis[row][col]=1;

        q.offer(new Pair(row,col));
         int n = grid.length;
         int m=grid[0].length;
        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().sec;
            q.poll();

            int[] dr = {-1,0,1,0};
            int[] dc ={0,1,0,-1};
            for(int k=0;k<4;k++)
            {
                
                    int nrow = r+dr[k];
                    int ncol = c+dc[k];
                    if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                        q.offer(new Pair(nrow,ncol));
                        vis[nrow][ncol]=1;
                    }
                
            }
        }



    }
}