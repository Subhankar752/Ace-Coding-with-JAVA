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
    List<List<Integer>> ans = new ArrayList<>();
    List<String> res = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        solve(root , targetSum , 0 , "");  
        enrich(res);
        return ans;
    }
    
    public void enrich(List<String> res){
        for(String list : res){
            String[] st = list.split("\\*");
            List<Integer> temp = new ArrayList<>();
            
            for(String s : st){
                if(s.length() > 0)
                    temp.add(Integer.parseInt(s));
            }
            
            ans.add(new ArrayList<>(temp));
        }
    }
    
    public void solve(TreeNode root , int sum , int cur , String asf){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(cur + root.val == sum)
            {asf = asf + Integer.toString(root.val);
            res.add(asf);
            return;}
        }
        solve(root.left , sum , cur + root.val , asf + Integer.toString(root.val)  + "*");
        solve(root.right, sum , cur + root.val , asf + Integer.toString(root.val) + "*");
    }
}