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
    int max = 0;
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        solve(root , 0);
        return ans;
    }
    public void solve(TreeNode root , int level){
        if(root == null)
            return;
        if(level >= max){
            ans.add(root.val);
            max++;
        }
        solve(root.right , level + 1);
        solve(root.left , level + 1);
    }
}