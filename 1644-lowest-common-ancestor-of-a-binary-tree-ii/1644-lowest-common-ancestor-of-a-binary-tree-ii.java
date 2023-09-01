/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = LCA(root, p, q);

        if (lca == p) {
            if (dfs(p, q)) {
                return p;
            } else {
                return null;
            }
        } else if (lca == q) {
            if (dfs(q, p)) {
                return q;
            } else {
                return null;
            }
        } else return lca;
    }

    public boolean dfs(TreeNode a, TreeNode b) {
        if (a == null) return false;
        if (a == b) return true;
        return dfs(a.left, b) || dfs(a.right, b);
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
