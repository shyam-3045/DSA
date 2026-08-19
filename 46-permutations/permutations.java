class Solution {
    private void getAll(int[] nums , List<List<Integer>> ans , boolean[]hash , List<Integer> ds)
    {
        if(ds.size() == nums.length)
        {   
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<hash.length;i++)
        {
            if(!hash[i]){
                ds.add(nums[i]);
                hash[i]=true;
                getAll(nums,ans,hash,ds);
                ds.remove(ds.size()-1);
                hash[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] hash = new boolean[nums.length];
        getAll(nums,ans,hash,new ArrayList<>());
        return ans; 
        
    }
}