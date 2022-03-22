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
     int pi;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pi = inorder.length - 1;
        return build(inorder,0,inorder.length-1,postorder);
    }
     public TreeNode build(int[] in , int start , int end , int[] post){
        if(start>end)
            return null;
        TreeNode node=new TreeNode(post[pi--]);
        if(start == end)
            return node;
        int index = getIndex(node.val , in , start , end);
        node.right = build(in , index + 1 , end , post);
        node.left = build(in , start , index - 1 , post);
        return node;
    }
    public int getIndex(int val , int[] in, int start , int end){
        for(int i = start ; i <= end ; i++){
            if(in[i] == val)
                return i;
        }
        return -1;
    }
   
}