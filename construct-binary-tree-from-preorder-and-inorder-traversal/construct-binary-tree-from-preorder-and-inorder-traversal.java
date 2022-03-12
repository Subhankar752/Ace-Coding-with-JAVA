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
    int pi=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder , inorder , 0 , preorder.length - 1);
    }
    public TreeNode build(int[] pre,int[] in,int start,int end){
        if(start>end)
            return null;
        TreeNode node=new TreeNode(pre[pi++]);
        if(start == end)
            return node;
        int index=getIndex(node.val , in , start , end);
        node.left=build(pre , in , start , index-1);
        node.right=build(pre , in , index+1 , end);
        return node;
    }
    public int getIndex(int val , int[] in, int start , int end){
        for(int i=start;i<=end;i++){
            if(in[i] == val)
                return i;
        }
        return -1;
    }
    
}