class Solution {
    public int hIndex(int[] c) {
        Arrays.sort(c);
        int n=c.length;

        for(int i=0;i<c.length;i++){
            if(c[i] >= n-i){
                return n-i;
            }
        }

        return 0 ;
       
    }

}