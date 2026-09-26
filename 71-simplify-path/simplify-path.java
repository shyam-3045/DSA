class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] paths = path.split("/");
        for(String ch :paths){
            if(ch.equals("") || ch.equals(".")){
                continue ;
            }
            else if(ch.equals(".."))
            {
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(String p : st){
            ans.append("/");
            ans.append(p);
        }

        return ans.length() == 0 ?"/" :ans.toString();
    }
}