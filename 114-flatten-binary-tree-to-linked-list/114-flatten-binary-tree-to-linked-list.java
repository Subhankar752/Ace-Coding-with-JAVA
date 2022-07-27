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
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> a = new ArrayList<>();
        preorder(root , a);
        root = null;
        int n = a.size();
        for(int i = 0 ; i < n ; i++){
            if(root == null)
                root = a.get(i);
            else{
                root.left = null;
                root.right = a.get(i);
                root = root.right;
        }
            
        
        }
    }
    public static void preorder(TreeNode root , ArrayList<TreeNode> a){
        if(root == null)
            return;
        a.add(root);
        preorder(root.left , a);
        preorder(root.right , a);
    }
}