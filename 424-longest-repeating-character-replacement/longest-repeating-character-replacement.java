class Solution {
    public int characterReplacement(String s, int k) {
         int l=0,r=0 , maxFreq =0 , max =0;
         int[] hash = new int[26];
         while(r < s.length()){
            hash[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq , hash[s.charAt(r) - 'A']);
            while((r-l+1) - maxFreq > k)
            {
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            if((r-l+1) - maxFreq <= k) max = Math.max(max , r-l+1);
            r++;
         }

         return max;
    }
}