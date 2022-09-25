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
    TreeNode ans;
    
    public TreeNode reverseOddLevels(TreeNode root) {
        solve(root);
        ans = enrich(list , 0);
        return ans;
    }
    
    public TreeNode enrich(ArrayList<Integer> list , int i){
        TreeNode root = null;
        
        if(i < list.size()){
            root = new TreeNode(list.get(i));
            
            root.left = enrich(list , 2 * i + 1);
            root.right = enrich(list , 2 * i + 2);
        }
        
        return root;
    }
    
    public void solve(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> res = new ArrayList<>();
            
            for(int i = 0 ; i < size ; i++){
                TreeNode cur = q.remove();
                res.add(cur.val);
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
            }
            
            if(level % 2 != 0){
                for(int i = res.size() - 1 ; i >= 0 ; i--){
                    list.add(res.get(i));
                }
            }
            else{
                for(int x : res)
                    list.add(x);
            }
            level++;
        }
    }
    
}