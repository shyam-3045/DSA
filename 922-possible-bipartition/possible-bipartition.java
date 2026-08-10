class Solution {

    private boolean isBipartite(int node , int[] col , int n , int[][] grid){
        col[node]=0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty())
        {
            int no = q.peek();
            q.poll();
            for(int k=1;k<=n;k++)
            {
                if(grid[no][k] == 1)
                {
                    if(col[k] == -1)
                    {
                        col[k] = 1-col[no];
                        q.offer(k);
                    }

                    else if(col[k] == col[no]) return false;
                }
            }
        }

        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] col = new int[n+1];

        for(int i=0;i<=n;i++) col[i]=-1;

        int[][] grid = new int[n+1][n+1];

        for(int[] edge : dislikes){
            int u=edge[0];
            int v = edge[1];

            grid[u][v]=1;
            grid[v][u]=1;

            
        }

        for(int i=1;i<=n;i++)
        {
            if(col[i] == -1)
            {
                if(!isBipartite(i , col , n,grid))
                {
                    return false;
                }
            }
        }

        return true;
    }
}