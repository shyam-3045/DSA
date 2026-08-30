class Solution {
    public int findMinArrowShots(int[][] points) {
       Arrays.sort(points,Comparator.comparingInt(row-> row[0]));
       int end = points[0][1];
       int n=1;
       for(int i=1;i<points.length;i++)
       {
        
         if(end >= points[i][0])
         {
            end = Math.min(end,points[i][1]);         
         }
         else 
         {
            end = points[i][1];
            n++;
         }   
       } 

        return n;
    }

   
}