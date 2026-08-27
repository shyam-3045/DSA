class Solution {

    private void fn(String s , int n ,List<String> path , List<List<String>> res)
    {
        if(n == s.length())
        {
            res.add(new ArrayList<>(path));
            return ;
        }

        for(int i=n;i<s.length();++i)
        {
            if(isPalindrome(s,n,i))
            {
                path.add(s.substring(n,i+1));
                fn(s,i+1,path,res);
                path.remove(path.size()-1);
            }
        }
        return ;
    }
    private boolean isPalindrome(String s, int st,int end)
    {
        while(st <= end)
        {
            if(s.charAt(st) != s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        fn(s,0,path,res);
        return res;
    }
}