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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> li = new ArrayList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int lev = q.size();
            long sum =0;

            for(int i =0;i<lev;i++)
            {
                TreeNode node = q.poll();
                if(node == null) continue;
                sum+=node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            li.add((double) sum / lev);
        }

        return li;
    }
}