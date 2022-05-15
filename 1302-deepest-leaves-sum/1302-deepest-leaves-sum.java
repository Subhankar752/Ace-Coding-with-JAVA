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
   int totalSum;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        
        //max number of node from root to leaf node (root is included)
        int maxDepth = getMaxDepth(root);
        
        totalSum = 0;
        
        //dfs
        deepestLeavesSum(root, 1, maxDepth);
        
        return totalSum; 
    }
    
    public void deepestLeavesSum(TreeNode root, int depth, int maxDepth) {
        if(root == null) return;
        
        if(depth == maxDepth){
            totalSum += root.val;
            return;
        }
        
        
        deepestLeavesSum(root.left, depth + 1, maxDepth);
        deepestLeavesSum(root.right, depth + 1, maxDepth);
    }
    
    private int getMaxDepth(TreeNode root){
        if(root == null) return 0;
        
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }
}