class Solution {

    private boolean dfs(int node , int[] vis , int[] pathVis , int[] check , int[][] graph , int n){
        vis[node] = 1;
        pathVis[node]=1;
        
        for(int ne : graph[node])
        {
           if(vis[ne] != 1)
                {
                    if(dfs(ne , vis,pathVis,check,graph,n)){
                        return true;
                    }
                }
            else if(pathVis[ne] == 1){
                    return true;
                } 
        }

        check[node]=1;
        pathVis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

       int[] vis = new int[n];
       int[] pathVis = new int[n];
       int[] check = new int[n];

       for(int i=0;i<n;i++)
       {
        if(vis[i] != 1 )
        {
            dfs(i,vis,pathVis,check,graph,n);
        }
       }

       List<Integer> safeNodes = new ArrayList<>();

       for(int i=0;i<n;i++)
       {
        if(check[i] == 1) safeNodes.add(i);
       }

       return safeNodes;

    }
}