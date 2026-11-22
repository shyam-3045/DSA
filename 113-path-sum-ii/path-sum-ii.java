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
    List<List<Integer>> ans = new ArrayList<>();
    private void fn(TreeNode root , int tar , ArrayList<Integer> path)
    {
        if(root ==  null) return ;
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == tar) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return ;
        }

        fn(root.left , tar - root.val,path);
        fn(root.right , tar - root.val,path);

        path.remove(path.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        fn(root,targetSum,new ArrayList<>());
        return ans;
    }
}