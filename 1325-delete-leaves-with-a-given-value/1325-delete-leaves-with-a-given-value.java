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

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        helper(root.left, target, root, true);
        helper(root.right, target, root, false);
        if (root.val == target && ((root.left == null) && (root.right == null))) return null;
        return root;
    }

    public void helper(TreeNode root, int target, TreeNode parent, boolean isLeft) {
        if (root == null) return;
        helper(root.left, target, root, true);
        helper(root.right, target, root, false);
        if ((target == root.val) && ((root.left == null) && (root.right == null))) {
            if (isLeft) parent.left = null; else parent.right = null;
        }
    }
}
