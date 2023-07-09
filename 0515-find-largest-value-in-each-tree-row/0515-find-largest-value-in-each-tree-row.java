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
    ArrayList<Integer> arr = new ArrayList<>();

    public void display(TreeNode root, int row) {
        if (root == null) {
            return;
        }
        if (arr.size() < row + 1) {
            arr.add(root.val);
        } else {
            arr.set(row, Math.max(root.val, arr.get(row)));
        }
        display(root.left, row + 1);
        display(root.right, row + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        display(root, 0);
        return arr;
    }
}
