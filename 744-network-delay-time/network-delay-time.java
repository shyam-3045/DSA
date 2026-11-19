class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] ed : times)
        {
            int u=ed[0];
            int v=ed[1];
            int d=ed[2];

            graph.get(u).add(new int[]{v,d});
        }

        int[] dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        dis[0]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        pq.offer(new int[]{0,k});

        while(!pq.isEmpty())
        {
            int d = pq.peek()[0];
            int node = pq.peek()[1];

            pq.poll();
            if(d > dis[node]) continue;

            for(int[] ed : graph.get(node))
            {
                int v = ed[0];
                int w=ed[1];

                if(dis[node] + w < dis[v])
                {
                    dis[v] = dis[node]+w;
                    pq.offer(new int[]{dis[v],v});
                }
            }
        }

        int ans =0;

        for(int t : dis)
        {
            if(t == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,t);
        }
        return ans;


    }
}