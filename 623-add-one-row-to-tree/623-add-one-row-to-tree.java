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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        // if depth is equal to 1
        if(depth == 1){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            root = newNode;
            return root;
        }
        
        // using bfs
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int curr = 0;
        
        
        while(!q.isEmpty()){
            curr = curr + 1;
            int size = q.size();
            if(depth == (curr + 1)){
                
                for(int i = 0 ; i < size ; i++){
                    
                    TreeNode node = q.poll();
                    
                    TreeNode newLeftNode = new TreeNode(val);
                    TreeNode newRightNode = new TreeNode(val);
                    
                    newLeftNode.left = node.left;
                    newRightNode.right = node.right;
                    
                    node.left = newLeftNode;
                    node.right = newRightNode;
                    
                    if(node.left != null) q.add(node.left);
                    if(node.right != null) q.add(node.right);
                    
                }
                
            }
            else{
                for(int i = 0 ; i < size ; i++){
                    TreeNode node = q.poll();
                    if(node.left != null) q.add(node.left);
                    if(node.right != null) q.add(node.right);
                }
            }
            
        }
        
        return root;
        
    }
}