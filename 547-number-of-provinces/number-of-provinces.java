class Solution {
    class DSU{
        int[] par;
        int[] size;

        DSU(int n)
        {
            par = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++)
            {
                par[i] =i;
                size[i]=1;
            }
        }

        int findPar(int u)
        {
            if(u == par[u]) return u;
            return par[u] = findPar(par[u]);
        }

        void union(int u , int v){
            int un_u = findPar(u);
            int un_v = findPar(v);

            if(un_u == un_v) return ;

            if(size[un_u] > size[un_v])
            {
                par[un_v] = un_u;
                size[un_u]+= size[un_v];
            }
            else{
                par[un_u] = un_v;
                size[un_v]+= size[un_u];  
            }

        }

    }
    // private void dfs(int[][] grid , int[] vis , int n )
    // {
    //     vis[n] = 1;
    //     for(int i=0;i<grid.length;i++)
    //     {
    //         if(grid[n][i] == 1 &&vis[i]== 0){
    //             dfs(grid,vis,i);
    //         }
    //     }
    // }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        // int[] vis = new int[n];
        // int cnt =0;

        // for(int i =0;i<n;i++)
        // {
        //     if(vis[i] == 0)
        //     {
        //         cnt++;
        //         dfs(isConnected , vis,i);
        //     }
        // }
        // return cnt;
        DSU dsu = new DSU(n);
        for(int i=0;i<n;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(isConnected[i][j] == 1) dsu.union(i,j);
            }
        }

        int cnt =0 ;
        for(int i=0;i<n;i++)
        {
            if(dsu.findPar(i) == i) cnt++;
        }

        return cnt;

    }
}