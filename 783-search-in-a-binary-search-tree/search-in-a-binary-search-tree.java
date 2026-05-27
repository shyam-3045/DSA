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
    public TreeNode searchBST(TreeNode root, int val) {
            TreeNode node = searchNode(root,val);
           return node ;
    }

    private TreeNode searchNode (TreeNode node , int val){
        if(node == null){
            return null ;
        }

        if(node.val == val)
        {
            return node ;
        }

        TreeNode ans = null ;

        if(val > node.val){
            ans = searchNode(node.right,val);
        }
        else if(val < node.val) {
            ans = searchNode(node.left,val);
        }

        return ans ;
    }
    
}