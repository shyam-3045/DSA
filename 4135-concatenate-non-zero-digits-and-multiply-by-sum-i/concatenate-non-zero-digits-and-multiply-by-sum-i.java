class Solution {
    public long sumAndMultiply(int n) {
        String num = Integer.toString(n);
        StringBuilder ans = new StringBuilder();
        int sum =0;
        for(char s : num.toCharArray()){
            if(s!= '0'){
                ans.append(s);
                sum += Character.getNumericValue(s);
            }
        }

        if(ans.length() == 0){
            return 0;
        }

        int number = Integer.parseInt(ans.toString());

        return (long) number * sum;

        
    }
}