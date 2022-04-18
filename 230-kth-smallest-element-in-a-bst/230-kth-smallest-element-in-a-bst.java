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
    public int kthSmallest(TreeNode root, int k) {
         ArrayList<Integer> a=new ArrayList<>();
        inorder(a,root);
        return a.get(k-1);
    }
    public void inorder(ArrayList<Integer> a,TreeNode root){
        if(root == null)
            return;
        inorder(a,root.left);
        a.add(root.val);
        inorder(a,root.right);
    }
}