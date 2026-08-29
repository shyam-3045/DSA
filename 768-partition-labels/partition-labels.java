class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        for(int i =0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        HashMap<Character,Integer> temp = new HashMap<>();
        int l =0 , r=0;
        while(r<s.length())
        {
            char ch = s.charAt(r);
            if(!temp.containsKey(ch)) 
            {
                temp.put(ch ,map.get(ch)-1);
                if(temp.get(ch) == 0) temp.remove(ch);
            }
            else 
            {
                temp.put(ch,temp.get(ch)-1);
                if(temp.get(ch) == 0) temp.remove(ch);
            }

            if(temp.isEmpty()) 
            {
                li.add(r-l+1);
                l=r+1;
            }
            r++;
        }

        return li;

    }
}