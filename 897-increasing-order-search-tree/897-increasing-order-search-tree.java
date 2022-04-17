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
    ArrayList<Integer> list = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(-1);
        TreeNode res = ans;
        inorder(root);
        for(int i : list){
                ans.right = new TreeNode(i);
                ans = ans.right;
        }
        return res.right;
    }
    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}