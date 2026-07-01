class Solution {
    public int diagonalSum(int[][] mat) {
        int sum =0;
        int col = mat[0].length;
        int row = mat.length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i == j){
                    sum+=mat[i][j];
                }
                if( i!=j && col - 1 - j == i){
                    sum+=mat[i][j];
                }
            }
        }

        return sum;
    }
}