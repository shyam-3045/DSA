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
    private int countPath(TreeNode node , long target)
    {
        if(node == null) return 0;
        int cnt =0;

        if(target - node.val == 0) cnt++;

        cnt+= countPath(node.left,target-node.val);
        cnt+= countPath(node.right,target-node.val);

        return cnt;

    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        int count = countPath(root,(long)targetSum);

        count += pathSum(root.left,targetSum);
        count+= pathSum(root.right,targetSum);

        return count;
    }
}