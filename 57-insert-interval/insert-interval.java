class Solution {
    public int[][] merge(int[][] inter) {
        List<int[]> li = new ArrayList<>();
        int i=0;

        while( i < inter.length){
            int j=i+1;
            int st = inter[i][0];
            int end =inter[i][1];

            while(j < inter.length && end >= inter[j][0]){
                end= Math.max(end , inter[j][1]);
                j++;
            }
            li.add(new int[]{st,end});
            i=j;
        }

        return li.toArray(new int[li.size()][]);
    }
    public int[][] insert(int[][] inter, int[] newInterval) {
        int[][] res=new int[inter.length +1][2];
        int i =0;
        int k=0;
        while(i<inter.length && inter[i][0] < newInterval[0])
        {
           res[k++]=inter[i++];
        }

        res[k++]=newInterval;

        while(i<inter.length)
        {
            res[k++]=inter[i++];
        }
        return merge(res);
    }
}