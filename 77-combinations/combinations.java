class Solution {
    private void getCombo(List<List<Integer>> ans , int k , int n , List<Integer> ds,int f){
        if(k==0 || n==0)
        {
            if(ds.size() == f)
            {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        ds.add(n);
        getCombo(ans,k -1 , n-1,ds,f);
        ds.remove(ds.size()-1);
        getCombo(ans,k,n-1,ds,f);
        
    }
    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> ans = new ArrayList<>();
      getCombo(ans,k,n,new ArrayList<>(),k);
      return ans;

    }
}