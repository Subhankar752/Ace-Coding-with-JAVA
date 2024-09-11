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
    int ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        solve(root);
        return ans;
    }

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(solve(root.left), 0);
        int rightSum = Math.max(solve(root.right), 0);
        
        ans = Math.max(ans, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}
