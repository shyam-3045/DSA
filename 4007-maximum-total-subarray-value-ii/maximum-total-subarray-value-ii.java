class Solution {

    class SegmentTree {

        int[] maxTree;
        int[] minTree;
        int n;

        SegmentTree(int[] nums) {

            n = nums.length;

            maxTree = new int[4*n];
            minTree = new int[4*n];

            build(nums,0,0,n-1);
        }

        void build(int[] nums,
                   int node,
                   int l,
                   int r)
        {
            if(l==r)
            {
                maxTree[node] = nums[l];
                minTree[node] = nums[l];
                return;
            }

            int mid = (l+r)/2;

            build(nums,2*node+1,l,mid);
            build(nums,2*node+2,mid+1,r);

            maxTree[node] =
                Math.max(maxTree[2*node+1],
                         maxTree[2*node+2]);

            minTree[node] =
                Math.min(minTree[2*node+1],
                         minTree[2*node+2]);
        }

        int queryMax(int node,int l,int r,int ql,int qr)
        {
            if(qr < l || ql > r)
            {
                return Integer.MIN_VALUE;
            }

            if(ql <= l && r <= qr)
            {
                return maxTree[node];
            }

            int mid = (l+r)/2;

            return Math.max(
                queryMax(2*node+1,l,mid,ql,qr),
                queryMax(2*node+2,mid+1,r,ql,qr)
            );
        }

        int queryMin(int node,int l,int r,int ql,int qr)
        {
            if(qr < l || ql > r)
            {
                return Integer.MAX_VALUE;
            }

            if(ql <= l && r <= qr)
            {
                return minTree[node];
            }

            int mid = (l+r)/2;

            return Math.min(
                queryMin(2*node+1,l,mid,ql,qr),
                queryMin(2*node+2,mid+1,r,ql,qr)
            );
        }
    }

    class Node {
        long value;
        int l;
        int r;

        Node(long val , int l , int r){
            this.value = val;
            this.l =l;
            this.r=r;
        }
    }

    public long maxTotalValue(int[] nums,int k)
    {
        int n = nums.length;

        SegmentTree seg = new SegmentTree(nums);
        PriorityQueue<Node> pq =new PriorityQueue<>((a, b) -> Long.compare(b.value, a.value));




        for(int l=0;l<n;l++){
            int r= n-1;
            int ma = seg.queryMax(0,0,n-1,l,r);
            int mi = seg.queryMin(0,0,n-1,l,r);

            long val = ma-mi;

            pq.add(new Node(val,l,r));
        }

        long ans =0;

        while (k > 0){
            Node curr = pq.poll();

            ans += curr.value;

            int l = curr.l;
            int r = curr.r;

            if (r - 1 >= l)
            {
                int newR = r - 1;

                int ma =
                    seg.queryMax(
                        0, 0, n - 1,
                        l, newR
                    );

                int mi =
                    seg.queryMin(
                        0, 0, n - 1,
                        l, newR
                    );

                long val = ma - mi;

                pq.add(
                    new Node(val, l, newR)
                );
            }

            k--;
        }

        return ans;

    }
}