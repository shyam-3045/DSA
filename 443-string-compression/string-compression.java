class Solution {
    public int compress(char[] chars) {
        StringBuilder st = new StringBuilder();
        char curr = chars[0];
        int cnt =0;

        for(char c : chars)
        {
            if(c == curr) cnt ++;
            else  {
                if(cnt == 1) st.append(curr);
                else st.append(curr).append(cnt);
                curr = c;
                cnt = 1;
            }
        
        }

        if(cnt == 1) st.append(curr);
        else st.append(curr).append(cnt);

        for(int i=0 ;i<st.length();i++)
        {
            chars[i] = st.charAt(i);
        }

        return st.length();
    }
}