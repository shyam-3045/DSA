class Solution {
    public boolean asteroidsDestroyed(int mass, int[] a) {
        long ans=mass;
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            if(ans < a[i])
            
            {
                return false;
            }
            ans = ans + a[i];
            
        }

        return true ;
    }
}