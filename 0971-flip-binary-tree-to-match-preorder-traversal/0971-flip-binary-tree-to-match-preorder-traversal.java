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
   int ind = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ans = new ArrayList<>();
        boolean match = solve(root, voyage, ans);
        if(match != false) return ans;
        else return Arrays.asList(-1);
    }

    boolean solve(TreeNode root, int[] voyage, List<Integer> ans){
        if(root == null) return true;
        
        if(root.val != voyage[ind]) return false;
        
        int temp = ind++;
        boolean res = solve(root.left, voyage, ans) && solve(root.right, voyage, ans);
        
        if(res == false){
            ind = ++temp;

            res = solve(root.right, voyage,  ans) && solve(root.left, voyage, ans); 
            if(res == true) ans.add(root.val);
        }

        return res;
    }
}