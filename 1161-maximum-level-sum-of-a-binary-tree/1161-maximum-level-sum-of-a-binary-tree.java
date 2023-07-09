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
    public int maxLevelSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int level = 0;
        int l =0;
        int max = Integer.MIN_VALUE;
        q.add(root);
        while(!q.isEmpty()) {
            int n =q.size();
            level++;
            int sum=0;
            for(int i=1;i<=n;i++) {
                TreeNode curr = q.poll();
                if(curr.left !=null) {
                    q.add(curr.left);
                }
                if(curr.right!=null) {
                    q.add(curr.right);
                }
                sum += curr.val; 
            }
            max= Math.max(max, sum);
            map.put(level, sum); 
        }
        for(Integer key: map.keySet()) {
            if(map.get(key) == max) {
                return key;
            }
        }
        return 0;
    }
}