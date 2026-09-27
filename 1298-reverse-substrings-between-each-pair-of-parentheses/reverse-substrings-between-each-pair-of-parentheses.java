class Solution {
    public String reverseParentheses(String s) {
       Stack<Character> st = new Stack<>();
       
       for(char ch : s.toCharArray())
       {
        if(ch == ')')
        {
            List<Character> li= new ArrayList<>();
            while(st.peek() != '('){
                li.add(st.pop());
            }
            st.pop();
            for(int i=0;i<li.size();i++) st.push(li.get(i));
        }
        else {
            st.push(ch);
        }
       }

       StringBuilder ans = new StringBuilder();

       for(char ch : st)
       {
        ans.append(ch);
       }

       return ans.toString();
    }
}

