class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
      String s = "123456789";
      int minLen = String.valueOf(low).length();
      int maxLen = String.valueOf(high).length();
      List<Integer> ans = new ArrayList<>();
      

      for(int i=minLen;i<=maxLen;i++){
        int x=0;
        while(x + i <=s.length()){
            String sub = s.substring(x,i+x);
            int num = Integer.parseInt(sub);
            if( num >= low && num <= high){
                ans.add(num);
            }
            if(num > high) break ;
            x++;
        }

      }

      return ans;  
    }
}