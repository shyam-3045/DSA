class Solution {

    private void dfs(int[][] graph , int node , boolean[] vis)
    {
        vis[node]=true;
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i] && graph[node][i] == 1)
            {
                dfs(graph,i,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
       int c =0;
       int n = isConnected.length;
       boolean[] vis = new boolean[n];

       for(int i=0;i<n;i++)
       {
        if(!vis[i])
        {
            c++;
            dfs(isConnected,i,vis);
        }
       }
       return c;
    }
    
}