class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        List<List<Integer>> li = new ArrayList<>();
        int prev=lower -1;
        for(int n:nums)
        {
            if(n < lower) continue;
            if(n > upper) break;

            if( n - prev >1)
            {
                li.add(Arrays.asList(prev+1,n-1));
            }

            prev =n;
        }
        if(prev < upper)li.add(Arrays.asList(prev+1,upper));

        return li;

    }
}