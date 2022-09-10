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
    int maxDiff = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        traverse(root , root.val , root.val);
        return maxDiff;
    }
    
    private void traverse(TreeNode node , int max , int min){
        if(node == null) return;
        
        maxDiff = Math.max(maxDiff , Math.abs(node.val - max));
        maxDiff = Math.max(maxDiff , Math.abs(node.val - min));
        
        traverse(node.left , Math.max(max , node.val) , Math.min(node.val , min));
        traverse(node.right , Math.max(max , node.val) , Math.min(node.val , min));
    }
}