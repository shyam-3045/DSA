class Solution {
    
    private boolean dfs(int[][] graph , int[] col , int node){


        col[node]=0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            int e = q.peek();
            q.poll();
            for(int ne : graph[e])
            {
                if(col[ne] == -1)
                {
                    col[ne] = 1- col[e];
                    q.offer(ne);
                }
                else if(col[ne] == col[e]) return false;
            }
        }


        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;;
        int[] col = new int[n];
        Arrays.fill(col,-1);

        for(int i =0;i<n;i++)
        {
            if(col[i] == -1)
            {
                if(!dfs(graph,col,i)) return false;
            }
        }
        return true;
    }
}