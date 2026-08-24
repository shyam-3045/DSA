class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i] , map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> li = new ArrayList<>();

        for(int i=1;i<=nums.length;i++)
        {
            if(!map.containsKey(i))li.add(i);
        }
        return li;
    }
}