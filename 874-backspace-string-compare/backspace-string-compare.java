class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(Character ch : s.toCharArray()){
            if(ch.equals('#')){
                if(!st1.isEmpty()){
                    st1.pop();
                }
            }
            else{
                st1.push(ch);
            }
        }
        StringBuilder string1 = new StringBuilder();
        for(Character ch :st1){
            string1.append(ch);
        }

        for(Character ch : t.toCharArray()){
            if(ch.equals('#')){
                if(!st2.isEmpty()){
                    st2.pop();
                }
            }
            else{
                st2.push(ch);
            }
        }
        StringBuilder string2 = new StringBuilder();
        for(Character ch :st2){
            string2.append(ch);
        }

        return string1.compareTo(string2) == 0 ? true : false;
        
    }
}