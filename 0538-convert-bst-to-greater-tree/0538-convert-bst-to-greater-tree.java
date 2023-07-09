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
   public TreeNode convertBST(TreeNode root){
        if (root!=null) sumConvertBST(root,0);
        return root;
    }
    public int sumConvertBST(TreeNode root , int biggerSum) {
        if (root.right != null) root.val += sumConvertBST(root.right, biggerSum);
        else root.val += biggerSum;
        return (root.left != null) ? sumConvertBST(root.left, root.val) : root.val;
    }
}