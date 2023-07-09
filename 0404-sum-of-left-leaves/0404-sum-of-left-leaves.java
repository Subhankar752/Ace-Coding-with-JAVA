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
    public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) 
        return 0;
        
    int ans = 0;
        
    if(root.left != null) {
        if(root.left.left == null && root.left.right == null) 
            ans += root.left.val;
        else 
            ans += sumOfLeftLeaves(root.left);
    }
        
    ans += sumOfLeftLeaves(root.right);
    
    return ans;
    }
}