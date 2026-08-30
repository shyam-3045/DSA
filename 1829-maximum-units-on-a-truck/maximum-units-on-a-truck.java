class Solution {
    public int maximumUnits(int[][] box, int truckSize) {
        Arrays.sort(box,Comparator.comparingInt((int[] row) -> row[1]).reversed());
        int n =0;

        for(int i=0;i<box.length;i++)
        {
            int b = box[i][0];
            int cap = box[i][1];

            while(b > 0 && truckSize > 0)
            {
                n += cap;
                b--;
                truckSize--;   
            }
            if(truckSize == 0) return n;
        }
        return n;
    }
}