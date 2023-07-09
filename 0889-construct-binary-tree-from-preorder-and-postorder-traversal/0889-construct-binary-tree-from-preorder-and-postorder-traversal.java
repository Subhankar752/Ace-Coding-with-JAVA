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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return dfs(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode dfs(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int postIndex = postStart;
        while (post[postIndex] != pre[preStart + 1]) {
            postIndex++;
        }
        int len = postIndex - postStart + 1;
        root.left = dfs(pre, preStart + 1, preStart + len, post, postStart, postIndex);
        root.right = dfs(pre, preStart + len + 1, preEnd, post, postIndex + 1, postEnd);
        return root;
    }
}
