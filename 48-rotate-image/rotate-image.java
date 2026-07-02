class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int temp = mat[i][j]; 
                mat[i][j]=mat[j][i]; 
                mat[j][i]=temp;
            }
        }

        for(int i=0;i<n;i++){
            reverse(mat[i]);
        }
    }

    private void  reverse(int[] arr){
        int l = 0;
        int r = arr.length-1;
        while(l < r){
            int temp = arr[l]; 
            arr[l]=arr[r]; 
            arr[r]=temp;
            l++;
            r--;

        }
    }
}