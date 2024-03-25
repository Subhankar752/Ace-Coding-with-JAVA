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

    public TreeNode recoverFromPreorder(String s) {
        Map<Integer, TreeNode> map = new HashMap<>();
        int i = 0;

        while (i < s.length()) {
            int dashLen = 0;
            while (i < s.length() && s.charAt(i) == '-') {
                i++;
                dashLen++;
            }

            int num = 0;
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + Character.getNumericValue(s.charAt(i));
                i++;
            }

            TreeNode node = new TreeNode(num);
            map.put(dashLen, node);

            if (dashLen > 0) {
                TreeNode parent = map.get(dashLen - 1);
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
        }

        return map.get(0);
    }
}
