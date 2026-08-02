class Solution {
    public int[][] merge(int[][] inter) {
        Arrays.sort(inter , Comparator.comparingInt(row -> row[0]));
        List<int[]> list = new ArrayList<>();
        int i =0;
              

        while(i < inter.length)
        {
            int st = inter[i][0];
            int end = inter[i][1];

            int j=i+1;
            while(j < inter.length&& end >= inter[j][0]){
                end = Math.max(inter[j][1],end);
                j++;
            }
            list.add(new int[]{st,end});
            i=j;
            
            

        }


        return list.toArray(new int[list.size()][]);
    }
}