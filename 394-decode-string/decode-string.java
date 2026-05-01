class Solution {
    public String decodeString(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();
        String ans ="";
        int num = 0;

        for(char ch : s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                num = num * 10 + (ch - '0');
            }
            else if (ch == '[')
            {
                st1.push(num);
                st2.push(ans);
                
                num = 0;
                ans ="";
            }

            else if (ch == ']')
            {
                int count = st1.pop();
                String element = st2.pop();

                StringBuilder x = new StringBuilder(element);

                for(int i=0;i<count;i++)
                {
                    x.append(ans);
                }

                ans = x.toString();


            } 
            else {
                ans += ch ;
            }
        }

        return ans;
        
    }
}