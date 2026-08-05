class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> list = new ArrayList<>();
        int c =0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

    
        for(int i=0;i<n;i++)
        {
            if(!vis[i]){
                c++;
                dfs(isConnected , i , vis);

            }
        }

        return c;
    }
    private void dfs(int[][] graph , int node ,boolean[] vis){
        vis[node] = true;
        for(int n=0 ;n<graph.length;n++){
            if(graph[node][n] == 1 && !vis[n]){
                dfs(graph , n, vis);
            }
        }
    }
}