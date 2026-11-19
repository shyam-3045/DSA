class Solution {
    private boolean check(String s , String p , int[] removable , int k)
    {
        boolean[] removed = new boolean[s.length()];

        for(int i=0;i<k;i++)
        {
            removed[removable[i]] = true;
        }

        int j=0;

        for(int i=0;i<s.length();i++)
        {
            if(!removed[i] && j < p.length()&& s.charAt(i) == p.charAt(j)) j++;
        }

        return j == p.length();

    }
    public int maximumRemovals(String s, String p, int[] removable) {
        int l =0;
        int r=removable.length;
        int ans =0;

        while(l <= r)
        {
            int mid = l + (r - l) /2;

            if(check(s,p,removable,mid))
            {
                ans = mid;
                l =mid+1;
            }
            else r = mid -1;
        }

        return ans;
    }
}