class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        HashMap<String,Integer> map = new HashMap<>();
        map.put("+",1);
        map.put("-",2);
        map.put("*",3);
        map.put("/",4);
        for(String t: tokens)
        {   
            if(map.get(t) != null)
            {
                if(map.get(t) == 1)
                {
                    int prev = st.pop();
                    int last = st.pop();
                    st.push(last + prev);
                }
                else if(map.get(t) == 2)
                {
                    int prev = st.pop();
                    int last = st.pop();
                    st.push(last - prev);
                }
                else if(map.get(t) == 3)
                {
                    int prev = st.pop();
                    int last = st.pop();
                    st.push(last * prev);
                }
                else {
                    int prev = st.pop();
                    int last = st.pop();
                    st.push(last / prev);
                }
            }
            else{
                st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }
}