class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] sArray = s.trim().toCharArray();
        for(int i=0;i< sArray.length;i++){
            char temp = sArray[i];
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        char[] tArr = t.trim().toCharArray();
        for(int i=0;i<tArr.length;i++){
            char temp = tArr[i];
            if(!map.containsKey(temp)){
                return false ;
            }
            map.put(temp,map.get(temp)-1);
            if(map.get(temp) == 0){
                map.remove(temp);
            }
        }

        return map.size() == 0 ? true : false ;


    }
}