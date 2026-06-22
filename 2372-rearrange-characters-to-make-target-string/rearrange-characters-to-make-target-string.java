class Solution {
    public int rearrangeCharacters(String s, String target) {
       int[] freq  = new int[26];
       int[] freq2  = new int[26];
       for(char c : s.toCharArray()){
        freq[c - 'a']++;
       }

       for(char c : target.toCharArray()){
        freq2[c-'a']++;
       }

       int ans = Integer.MAX_VALUE;

       for(char c : target.toCharArray()){
        ans=Math.min(ans , freq[c-'a'] / freq2[c-'a']);
       }
       return ans;


    }
}