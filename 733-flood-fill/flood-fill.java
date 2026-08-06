class Solution {

    private void dfs(int sr , int sc ,int[][] grid , int color ,int initCol,int[][] ans ,int[] delRow , int[] delCol){

        grid[sr][sc]=color;
        int row = grid.length;
        int col=grid[0].length;
        for(int i=0;i<4;i++){
            int nrow=sr - delRow[i];
            int ncol=sc-delCol[i];
            if(nrow >= 0 && nrow<row && ncol >=0 && ncol <col && grid[nrow][ncol] == initCol && grid[nrow][ncol] != color){
                dfs(nrow,ncol,grid
                ,color,initCol,ans,delRow,delCol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int initCol = image[sr][sc];
      int[][] ans = image;
      int[] delRow={-1,0,1,0};
      int[] delCol = {0,1,0,-1};
      dfs(sr,sc,image,color,initCol,ans,delRow,delCol); 

      return ans; 
    }
}