class Solution {

    private boolean dfs(int node , int[] vis , int[] pathVis , int[][] graph , int n)
    {
        vis[node]=1;
        pathVis[node]=1;

        for(int i=0;i<n;i++)
        {
            if(graph[node][i] == 1)
            {
                if(vis[i] != 1)
                {
                    if(!dfs(i,vis,pathVis,graph,n)){
                        return false;
                    }
                }
                else if(pathVis[i] == 1)
                {
                    return false;
                }
            }
        }
        pathVis[node]=0;
        return true;
    }
    
    public boolean canFinish(int n, int[][] prerequisites) {
       int[] vis = new int[n];
       int[] pathVis = new int[n];

       int[][] graph  = new int[n][n];

       for(int i=0;i<prerequisites.length;i++)
       {
        int u= prerequisites[i][0];
        int v = prerequisites[i][1];

        graph[u][v] = 1;
       }

       for(int i=0;i<n;i++)
       {
        if(vis[i] != 1)
        {
            if(!dfs(i,vis,pathVis,graph,n)){
                return false;
            }
        }
       }

       return true;


    }
}