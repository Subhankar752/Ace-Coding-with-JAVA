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
    public boolean isCompleteTree(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        
        while(q.size() > 0){
            int size = q.size();
            
            for(int i = 0 ; i < size ; i++){
                TreeNode cur = q.remove();
                
                if(cur.left != null){
                    q.add(cur.left);
                    
                    if(flag)
                        return false;
                }
                else{
                    flag = true;    
                }
                
                if(cur.right != null){
                    q.add(cur.right);
                    
                    if(flag)
                        return false;
                }
                else{
                    flag = true;
                }
            }
        }
        
        return true;
    }
}