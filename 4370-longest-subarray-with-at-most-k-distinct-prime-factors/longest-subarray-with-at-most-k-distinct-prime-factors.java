class Solution {
    private List<Integer> getPrime(int n)
    {
        List<Integer> fac = new ArrayList<>();
        for(int i=2;i*i <=n;i++)
        {
            if(n%i == 0)
            {
                fac.add(i);
                while(n%i == 0)
                {
                    n/=i;
                }
            }
        }
        if(n > 1) fac.add(n);
        return fac;
    }
    public int longestSubarray(int[] nums, int k) {
        int l=0;
        int r=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans =0;
        while(r<nums.length)
        {
            for(int f : getPrime(nums[r]))
            {
                map.put(f,map.getOrDefault(f,0)+1);
            }
            while(map.size() > k)
            {
                for(int f : getPrime(nums[l]))
                {
                    map.put(f,map.get(f) -1);
                    if(map.get(f) == 0)map.remove(f);
                }
                l++;
            }
            ans= Math.max(ans,r-l+1);
            r++;            
        }
        return ans;
    }
}