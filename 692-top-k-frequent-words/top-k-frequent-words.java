class Solution {
    class Pair {
        String word ;
        int freq ;

        Pair(String word , int freq){
            this.word = word ;
            this.freq = freq ; 
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String , Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.freq == b.freq){
                return b.word.compareTo(a.word);
            }

            return a.freq - b.freq ;
        });

        for(String w : words){
            map.put(w,map.getOrDefault(w,0)+1);
        }

        for(String s : map.keySet()){
            pq.offer(new Pair(s,map.get(s)));

            if(pq.size() > k){
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();

        while(!pq.isEmpty()){
            String s = pq.peek().word;
            ans.add(s);
            pq.poll();
        }

        Collections.reverse(ans);

        return ans ;
    }
}