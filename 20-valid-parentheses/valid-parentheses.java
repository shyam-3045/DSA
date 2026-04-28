import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char ch : s.toCharArray()) {

            if (map.containsKey(ch)) {  
                if (st.isEmpty() || st.pop() != map.get(ch)) {
                    return false;
                }
            } else {
                st.push(ch);  
            }
        }

        return st.isEmpty();
    }
}