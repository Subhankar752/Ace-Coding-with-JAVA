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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        return solve(nums , root , 0 , nums.length - 1);
    }
    public TreeNode solve(int[] nums , TreeNode root , int l , int r){
        if(l > r)
            return null;
        int mid = l + (r - l) / 2;
        root = new TreeNode(nums[mid]);
        root.left = solve(nums , root , l , mid - 1);
        root.right = solve(nums , root , mid + 1 , r);
        return root;
    }
}