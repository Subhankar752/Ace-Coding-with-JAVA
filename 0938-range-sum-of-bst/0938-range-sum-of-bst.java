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
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        solve(root, low, high);
        
        return sum;
    }
    
    public void solve(TreeNode root, int l, int h) {
        if (root == null) {
            return;
        }
        
        if (root.val >= l && root.val <= h) {
            sum += root.val;
        }
        
        solve(root.left, l, h);
        solve(root.right, l, h);
    }
}