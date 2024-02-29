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

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();

        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                List<TreeNode> list = new ArrayList<>();

                if (map.containsKey(level)) {
                    list = map.get(level);
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

        for (Map.Entry<Integer, List<TreeNode>> m : map.entrySet()) {
            int key = m.getKey();
            List<TreeNode> val = m.getValue();

            if (key % 2 == 0) {
                if (!allOdd(val) || !allInc(val)) {
                    return false;
                }
            } else {
                if (!allEven(val) || !allDec(val)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean allInc(List<TreeNode> list) {
        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).val <= prev) {
                return false;
            }
            prev = list.get(i).val;
        }

        return true;
    }

    public boolean allDec(List<TreeNode> list) {
        int prev = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).val >= prev) {
                return false;
            }
            prev = list.get(i).val;
        }

        return true;
    }

    public boolean allOdd(List<TreeNode> list) {
        for (TreeNode i : list) {
            if (i.val % 2 == 0) {
                return false;
            }
        }

        return true;
    }

    public boolean allEven(List<TreeNode> list) {
        for (TreeNode i : list) {
            if (i.val % 2 == 1) {
                return false;
            }
        }

        return true;
    }
}
