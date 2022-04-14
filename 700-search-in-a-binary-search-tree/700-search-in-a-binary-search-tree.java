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
        TreeNode v = solve(root , val);
        return v;
    }
    public TreeNode solve(TreeNode root , int val){
        if(root == null)
            return null;
        if(root.val == val){
            return root;
        }
        if(root.val > val){
            return solve(root.left , val);
        }
        else{
            return solve(root.right , val);
        }
    }
}