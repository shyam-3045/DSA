class Solution {

    class Pair {
        int val ;
        int acc ;

        Pair(int val , int acc){
            this.val = val ;
            this.acc = acc ;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.acc - b.acc);



        for(int key : map.keySet()){
            int val = map.get(key);
            Pair pair = new Pair(key,val);
            pq.offer(pair);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[k];

        int i =0;
        while(!pq.isEmpty()){
            ans[i]=pq.poll().val;
            i++;
        }

        return ans;
    }
}