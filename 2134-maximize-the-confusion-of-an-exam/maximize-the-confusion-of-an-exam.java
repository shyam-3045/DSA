class Solution {
    public int maxConsecutiveAnswers(String key, int k) {
        int l =0 , r= 0, max =0 , maxFreq=0;
        int[] hash = new int[26];

        while(r < key.length())
        {
            hash[key.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq , hash[key.charAt(r) - 'A']);
            while((r-l+1) - maxFreq > k)
            {
                hash[key.charAt(l) - 'A']--;
                l++;
            }
            if((r-l+1) - maxFreq<= k) max= Math.max(max , (r-l+1) );
            r++;
        }

        return max;
    }
}