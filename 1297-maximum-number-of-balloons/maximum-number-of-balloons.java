class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] hash = new int[26];
        for(char ch : text.toCharArray()){
            hash[ch -'a']++;
        }

        return Math.min(Math.min(hash['b' -'a'] , hash['a'-'a']) , Math.min(hash['l'-'a'] /2 , Math.min(hash['o' -'a'] /2 , hash['n'-'a'])));


        
    }
}