class Solution {
    public int strStr(String haystack, String needle) {

        if(needle.length() > haystack.length()){
            return -1;
        }
        StringBuilder ans1 = new StringBuilder();

        for(int i=0;i<needle.length();i++){
            ans1.append(haystack.charAt(i));

        }

        for(int l=0 ,r=needle.length();; l++ ,r++)
        {
            if(ans1.toString().compareTo(needle) == 0){
                return l;
            }

            if(r == haystack.length()) break;

            ans1.deleteCharAt(0);
            ans1.append(haystack.charAt(r));
        }
        

        return -1 ;
    }
}