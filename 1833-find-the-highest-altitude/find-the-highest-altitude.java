class Solution {
    public int largestAltitude(int[] gain) {
      int val =0;
      int max =0;
      for(int i=0;i<gain.length;i++ ){
        val += gain[i];
        if(val > 0){
            max = Math.max(val,max);
        }
        
      }  

      return max ;
    }
}