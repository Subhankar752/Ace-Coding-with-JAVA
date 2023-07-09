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
    public List<TreeNode> allPossibleFBT(int n) {
       
	   List<TreeNode> res = new ArrayList<>();
		
        if(n%2==0) return res; // if n is even, no complete B-tree possible
		
        if(n == 1){ // if n is 1, only 1 complete B-tree is possible (0 or 2 children)
            res.add(new TreeNode(0));
                return res;
        }
        
        for(int i=1; i<n; i+=2){
		
            List<TreeNode> left = allPossibleFBT(i); //recursive call for left subtree children
			
            List<TreeNode> right = allPossibleFBT(n-i-1); //recursive call for right subtree children
            
            for(TreeNode l:left){  //for - each loop of java is used here
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(0); //iterating values, making trees
                    root.left = l;
                    root.right = r;
                    res.add(root); //filling up the results in list
                }
            }
        }
        return res;
    }
}