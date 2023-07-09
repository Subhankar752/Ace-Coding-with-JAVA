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
    private String ans = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder(""));
        return ans;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        sb.append((char) (root.val + 'a'));
        
        if (root.left != null) dfs(root.left, sb);
        
        if (root.right != null) dfs(root.right, sb);
        
        if (root.left == null && root.right == null) {
            String temp = sb.reverse().toString();
            if (ans.equals("") || temp.compareTo(ans) < 0) ans = temp;
            sb.reverse();
        }
        
        sb.deleteCharAt(sb.length() - 1);
    }
}
