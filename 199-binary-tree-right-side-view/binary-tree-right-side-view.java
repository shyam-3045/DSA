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
    List<Integer> ds = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        Traversal(root,0);
        return ds ;
    }
    private void Traversal(TreeNode node , int level){
        if(node == null){
            return ;
        }

        if(level == ds.size())
        {
            ds.add(node.val);
        }

        Traversal(node.right,level+1);
        Traversal(node.left,level+1);

    
    }
}