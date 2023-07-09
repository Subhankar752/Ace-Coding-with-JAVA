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
    TreeNode h = null;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode head = null;
        List<Integer> l = new ArrayList<>();
        for (int i : nums) l.add(i);
        return insert(h, l);
    }

    TreeNode insert(TreeNode n, List<Integer> l) {
        if (l.size() == 0) {
            return null;
        }
        int m = Collections.max(l);
        n = new TreeNode(m);
        n.left = insert(n.left, l.subList(0, l.indexOf(m)));
        n.right = insert(n.right, l.subList(l.indexOf(m) + 1, l.size()));
        return n;
    }
}
