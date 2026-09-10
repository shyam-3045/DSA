/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int cnt =0;
    class Pair{
        int sum;
        int no ;

        Pair(int s , int n)
        {
            this.sum =s;
            this.no =n;
        }
    }
    private Pair fn(TreeNode node)
    {
        if(node == null) return new Pair(0,0);
        Pair lsum = fn(node.left);
        Pair rsum = fn(node.right) ;
       
        int avg =( node.val + lsum.sum + rsum.sum) / (lsum.no + rsum.no+1);
        
        if(avg == node.val) cnt++;

        return new Pair(node.val + lsum.sum + rsum.sum,lsum.no + rsum.no+1);
    }
    public int averageOfSubtree(TreeNode root) {
        fn(root);
        return cnt ;
    }
}