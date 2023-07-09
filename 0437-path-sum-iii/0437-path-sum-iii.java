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
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        solve(root, targetSum, 0L, map);
        return count;
    }

    private void solve(TreeNode root, int targetSum, long sum, Map<Long, Integer> map) {
        if (root == null) {
            return;
        }
        sum = sum + root.val;
        
        long gain = sum - targetSum;
        
        if (map.containsKey(gain)) {
            count = count + map.get(gain);
        }
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        solve(root.left, targetSum, sum, map);
        solve(root.right, targetSum, sum, map);
        
        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }
}
