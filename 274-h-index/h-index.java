class Solution {
    public int hIndex(int[] c) {
        // Arrays.sort(c);
        // int n=c.length;

        // for(int i=0;i<c.length;i++){
        //     if(c[i] >= n-i){
        //         return n-i;
        //     }
        // }

        // return 0 ;

        int n = c.length;
        int[] count = new int[n+1];

        for(int i=0;i<n;i++){
            if(c[i] >= n){
                count[n]++;
            }
            else{
                count[c[i]]++;
            }
            
        }

        int papers =0;
        

        for(int i=n;i>=0;i--){
            papers += count[i];

            if(papers >= i){

                return i;
            }
        }

        return 0;
       
    }

}