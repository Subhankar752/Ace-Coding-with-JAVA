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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        
        if(key<root.val){                            
            root.left = deleteNode(root.left,key);
            return root;
        }
        
        else if(key>root.val){
            root.right = deleteNode(root.right,key);
            return root;
        }
        
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                TreeNode min = root.right;
                while(min.left!=null){
                    min = min.left;
                }
                
                root.val = min.val;
                root.right = deleteNode(root.right,min.val);
                return root;
            }
        }
//         if(root == null)
//             return null;
//         if(root.val < key)
//         {
//             deleteNode(root.right , key);
//             return root;
//         }
//         else if(root.val > key)
//         {
//             deleteNode(root.left , key);
//             return root;
//         }
//         else{
//             if(root.left == null)
//                 return root.right;
//             else if(root.right == null)
//                 return root.left;
//             else{
//             root.val = solve(root.right);
//             root.right = deleteNode(root.right ,root.val);
//             return root;
// //                 TreeNode min = root.right;
// //                 while(min.left!=null){
// //                     min = min.left;
// //                 }
                
// //                 root.val = min.val;
// //                 root.right = deleteNode(root.right,min.val);
// //                 return root;
//             }
//         }
        
    }
    public int solve(TreeNode root){
        while(root.left != null)
            root = root.left;
        return root.val;
    }
}