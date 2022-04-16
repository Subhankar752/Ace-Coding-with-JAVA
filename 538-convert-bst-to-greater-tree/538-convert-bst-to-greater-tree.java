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
    ArrayList<Integer> list = new ArrayList<>();
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
        // inorder(root);
        // HashMap<Integer , Integer> map = new HashMap<>();
        // int sum = 0;
        // int n = list.size();
        // for(int i = n - 1 ; i >=  0 ; i--){
        //     sum += list.get(i);
        //     map.put(list.get(i) , sum);
        // }
        // solve(root , map);
        // return root;
    }
    
    public void solve(TreeNode root , HashMap<Integer , Integer> map){
            if(root == null)
                return;
        solve(root.left , map);
        root.val = map.get(root.val);
        solve(root.right , map);
    }
    
    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}