class Solution {
    public int lastStoneWeight(int[] stones) {

    
        if(stones == null || stones.length == 0){
            return 0;
        }
      PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

      for(int st : stones){
        pq.offer(st);
      }

      while(pq.size() > 1){
        int y = pq.poll();
        int x = pq.poll();
        if(y > x){
            pq.offer(y-x);
        }

      }

      if(pq.size() == 1 ){
           return pq.peek() ;
        }

      return 0;  
    }
}