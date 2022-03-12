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
    List<Integer> list = new ArrayList<>();
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root , 0);
        for(int i : list){
            if(i == targetSum)
                return true;
        }
        return false;
    }
    public void dfs(TreeNode root , int cur){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            int x = cur + root.val;
            list.add(x);
            return;
        }
        dfs(root.left , cur + root.val);
        dfs(root.right , cur + root.val);
    }
}