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
    int sumRoot=0;
    public int sumNumbers(TreeNode root) {
        sum(root , 0);
         return sumRoot;
    }
    public void sum(TreeNode root , int i){
	    if(root == null)
	    return;
	    if(root.left == null && root.right == null){
	        sumRoot += (i*10 + root.val);
	        return;
	    }
	    sum(root.left , i*10 + root.val);
	    sum(root.right , i*10 + root.val);
	}
}