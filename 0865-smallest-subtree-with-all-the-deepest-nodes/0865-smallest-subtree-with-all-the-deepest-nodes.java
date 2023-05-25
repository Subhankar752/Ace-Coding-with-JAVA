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
   public TreeNode subtreeWithAllDeepest(TreeNode root) {
if (root == null)
return null;

    TreeNode leftMost = null, rightMost = null;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    //Doing level-order Traversal and finding LeftMost/Rightmost node in a tree.
    while (!queue.isEmpty()) {

        int size = queue.size();
        for (int i = 0; i < size; i++) {

            TreeNode node = queue.poll();

            if (i == 0)
                leftMost = node;

            if (i == size - 1)
                rightMost = node;

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }
    }

    return lca(root, leftMost, rightMost);
}

private static TreeNode lca( TreeNode root, TreeNode leftNode, TreeNode rightNode ) {

    //Base Case : Checking if root reaches leftMost/rightMost
    if (root == null || leftNode == root || rightNode == root) {
        return root;
    }

    //Traverse Right/Left
    TreeNode left = lca(root.left, leftNode, rightNode);
    TreeNode right = lca(root.right, leftNode, rightNode);

    if (left != null && right != null) {
        return root;
    }

    return left == null ? right : left;
}
}