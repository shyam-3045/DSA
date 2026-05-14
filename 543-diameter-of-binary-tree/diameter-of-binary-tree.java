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

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        height(root);

        return ans ;



}
    private int  height(TreeNode node)
    {
        if (node == null)
        {
            return 0 ;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        ans = Math.max(ans , lh+rh);

        return 1 + Math.max(lh,rh);
    }
}