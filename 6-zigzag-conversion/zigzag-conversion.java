class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()){
            return s ;
        }

        List<StringBuilder> rows = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            rows.add(new StringBuilder());
        }

        int dir = 1;
        int row = 0;

        for(int i=0;i<s.length();i++){
            rows.get(row).append(s.charAt(i));
            if(row == 0){
                dir =1;
            }
            if(row == numRows-1){
                dir =-1;
            }

            row+=dir;
        }

        StringBuilder ans = new StringBuilder();

        for(StringBuilder sb : rows){
            ans.append(sb);
        }

        return ans.toString();


    }
}