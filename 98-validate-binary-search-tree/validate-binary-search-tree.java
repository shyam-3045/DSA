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
    private boolean dfs(TreeNode root , long l , long r){
        if(root == null) return true;

        if(root.val <= l || root.val >= r) return false;

        boolean lr = dfs(root.left,l,root.val);
        boolean rr = dfs(root.right,root.val,r);

        return lr && rr;

    }
    public boolean isValidBST(TreeNode root) {
      return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);  
    }
}