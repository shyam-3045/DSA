class Solution {
    public int lastStoneWeight(int[] stones) {
      PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

      for(int st : stones){
        pq.offer(st);
      }

      while(!pq.isEmpty()){
        if(pq.size() == 1 ){
           return pq.peek() ;
        }
        int y = pq.poll();
        int x = pq.poll();

        int ans = y-x ;
        if(ans > 0){
            pq.offer(ans);
        }

      }

      return 0;  
    }
}