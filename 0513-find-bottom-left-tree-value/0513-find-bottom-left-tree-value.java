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

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                
                List<TreeNode> list;
                if (map.containsKey(level)) {
                    list = map.get(level);
                } else {
                    list = new ArrayList<>();
                }

                list.add(cur);
                map.put(level, list);

                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }

            level++;
        }

        return map.get(level - 1).get(0).val;
    }
}
