class Solution {
    class Pair {
        int[] pair;
        int dis ;

        Pair(int[] pair ,int dis){
            this.pair = pair ;
            this.dis = dis;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.dis - a.dis);
        for(int i=0 ;i<points.length;i++ ){
            int x2 = points[i][0];
            int y2 = points[i][1];

            int  dis =x2*x2 + y2*y2;
            Pair temp = new Pair(points[i] , dis);
            pq.offer(temp);
            if(pq.size() > k){
                pq.poll();
            }
            

        }
        int[][] ans = new int[k][2];
        int i=0;

        while(!pq.isEmpty()){   
            ans[i++] = pq.poll().pair; 
        }

        return ans ;
    }
}