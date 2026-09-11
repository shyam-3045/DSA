class Solution {
    private void fn(int[] dig , int[] vis , ArrayList<Integer> ds,HashSet<Integer> set)
    {
        if(ds.size() == 3)
        {
            int num = ds.get(0) *100 + ds.get(1)*10 + ds.get(2);
            if(num % 2 ==  0)
            {
                set.add(num);
            }
            return;
        }


        for(int i=0;i<dig.length;i++)
        {
            if(vis[i] == 1) continue;
            if(ds.size() == 0 && dig[i] == 0) continue;
            
            vis[i] =1;
            ds.add(dig[i]);
            fn(dig , vis,ds,set);
            ds.remove(ds.size()-1);
            vis[i]=0;
        }
        return;
    }
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        int[] vis = new int[n];
        HashSet<Integer> set = new HashSet<>();

        fn(digits , vis, new ArrayList<>(),set);

        return set.size();


    }
}