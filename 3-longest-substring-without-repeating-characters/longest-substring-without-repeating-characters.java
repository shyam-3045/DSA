class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash =new int[256];

        for(int i=0;i<hash.length;i++)
        {
            hash[i]=-1;
        }

        int r=0;
        int l=0;
        int maxLen=0;
        int n=s.length();

        while(r<n)
        {
            if(hash[s.charAt(r)] != -1)
            {
                if(hash[s.charAt(r)] >= l)
                {
                    l=hash[s.charAt(r)]+1;
                }
            }
            
            maxLen=Math.max(maxLen,r-l+1);
            hash[s.charAt(r)]=r;
            r++;
        }

        return maxLen;


    }
}