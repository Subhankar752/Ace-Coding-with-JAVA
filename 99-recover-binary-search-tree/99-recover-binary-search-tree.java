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
    List<Integer> sorted = new ArrayList<>();
    HashMap<Integer , Integer> map;
    
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root , list);
        for(int i = 0 ; i < list.size() ; i++)
            sorted.add(list.get(i));
        Collections.sort(sorted);
        for(int i = 0 ; i < list.size() ; i++)
            System.out.println(list.get(i) + " " + sorted.get(i));
        map = new HashMap<>();
        for(int i = 0 ; i < list.size() ; i++){
            int a = list.get(i);
            int b = sorted.get(i);
            if(a != b){
                map.put(a , b);
            }
        }
        traverse(root);
    }
    
    public void traverse(TreeNode root){
        if(root == null)
            return;
        if(map.containsKey(root.val) == true){
            root.val = map.get(root.val);
        }
        traverse(root.left);
        traverse(root.right);
    }
    
    private void helper(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
    
    // private void recover(TreeNode root, List<Integer> list) {
    //     if(root == null) {
    //         return;
    //     }
    //     recover(root.left, list);
    //     root.val = list.get(index++);
    //     recover(root.right, list);
    // }
}