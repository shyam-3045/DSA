class Solution {
    private boolean dfs(int node , int des ,List<List<Integer>> graph ,boolean[] vis){
        if(node == des)
        {
            return true;
        }

        vis[node]=true; 

        for(int ne:graph.get(node))
        {
            if(!vis[ne])
            {
                if(dfs(ne,des,graph,vis)) return true;
            }
        }

        return false; 
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] ed : edges)
        {
            int u = ed[0];
            int v = ed[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        return dfs(source,destination,graph,vis);
}
}