class Solution {
    class DSU {
        int[] par;
        int[] size;

        DSU(int n){
            par = new int[n];
            size = new int[n];

            for(int i=0;i<n;i++)
            {
                par[i] = i;
                size[i]=1;
            }
        }

        int find(int u)
        {
            if(u == par[u]) return u;
            return par[u] = find(par[u]);
        }

        void union(int u , int v){
            int un_u = find(u);
            int un_v =find(v);

            if(un_v == un_u) return ;

            else if(size[un_v] > size[un_u])
            {
                par[un_u] = un_v;
                size[un_v]+=size[un_u];
            }
            else{
                par[un_v] = un_u;
                size[un_u]+=size[un_v];
            }
        }
    }

    int max =0;

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m= grid[0].length;

        DSU dsu = new DSU(n*m);

        int[] delrow = {-1,0,1,0};
        int[] delcol = { 0,1,0,-1};

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 0) continue;
                for(int k=0;k<4;k++)
                {
                    int drow = i+delrow[k];
                    int dcol = j+delcol[k];

                    if(drow >=0 && drow < n&& dcol >=0 && dcol <m)
                    {
                        if(grid[drow][dcol] == 1)
                        {
                            int node = i * m + j;
                            int adjnode = drow * m + dcol;
                            dsu.union(node,adjnode);
                        }
                    }
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1) continue;
                HashSet<Integer> set= new HashSet<>();
                for(int k=0;k<4;k++)
                {
                    int drow = i+delrow[k];
                    int dcol = j+delcol[k];

                    if(drow >=0 && drow < n&& dcol >=0 && dcol <m)
                    {
                        if(grid[drow][dcol] == 1)
                        {
                            int adjnode = drow * m + dcol;
                            set.add(dsu.find(adjnode));
                            
                        }
                    }
                }
                int size = 0;
                for(Integer s: set)
                {
                    size +=dsu.size[s];
                }
                max = Math.max(max ,size+1);

            }
        }

        for(int i =0;i < n*m;i++ )
        {
            max = Math.max(max,dsu.size[dsu.find(i)]);
        }

        return max;

        

    }
}