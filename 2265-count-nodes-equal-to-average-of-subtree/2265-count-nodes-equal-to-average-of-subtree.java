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
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private Pair dfs(TreeNode node) {
        if(node == null) {
            return new Pair(0 , 0);
        }
        
        Pair left = dfs(node.left);
        Pair right = dfs(node.right);
        
        int currSum = left.b + right.b + node.val;
        int currCount = left.a + right.a + 1;
        
        if(currSum / currCount == node.val) {
            res++;
        }
            
        return new Pair(currCount , currSum);
    }
}