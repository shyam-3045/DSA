class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++)
        {
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i),0)+1);
        }
        int ans =0;
        boolean flag = false ;

        for(Character entry : map.keySet()){
            int value = map.get(entry);
            if(value  % 2 == 0)
            {
                ans += value;
            }
            else{
                ans += value -1;    
                flag = true;
            }
        }

        if(flag) ans+=1;
        return ans ;
        

    }
}