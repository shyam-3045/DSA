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
    int max = Integer.MIN_VALUE ;
    public int maxPathSum(TreeNode root) {
        height(root);
        return max ;
    }

    private int height(TreeNode node){
        if (node == null)
        {
            return 0;
        }

        int lSum = Math.max(0,height(node.left));
        int rSum = Math.max(0,height(node.right));

        max = Math.max(max , lSum+rSum+node.val);

        return Math.max(lSum,rSum) + node.val ;

    }
}