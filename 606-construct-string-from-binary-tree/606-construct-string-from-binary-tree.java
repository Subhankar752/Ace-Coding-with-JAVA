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
   void InOrder(TreeNode root, List<String> ds){
		if(root==null) return;

		ds.add("("+root.val);
		InOrder(root.left,ds);
		if(root.left==null && root.right!=null){
			ds.add("()");
		}
		InOrder(root.right,ds);
		ds.add(")");            

	}


	public String tree2str(TreeNode root) {

		List<String> ds=new LinkedList<>();

		InOrder(root,ds);
		String ans="";
		for(int i=0;i<ds.size();i++){
			ans+=ds.get(i);
		}

		return ans.substring(1,ans.length()-1);
	}
}