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
    int tmp = 0;
    boolean counter = false;
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        //base case
        if (root == null) return 0;
        getMinimumDifference(root.left);

        int difference = root.val - tmp;
        tmp = root.val;
        if ((minDiff > difference) && counter) minDiff = difference;
        counter = true;
        getMinimumDifference(root.right);
        return minDiff;
    }
}
