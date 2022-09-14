class Solution {
  private int digits[], ans;
  
  private void isPolindrome(){
    boolean odd = false;
    
    for(int n: digits)
      if( (n&1) == 1 )
        if(odd) return;
        else odd = true;
     
    ans++;
  }
  
  private void dfs(TreeNode root){
    digits[root.val]++;
    
    if(root.left == null && root.right == null) isPolindrome();
    if(root.left  != null) dfs(root.left);
    if(root.right != null) dfs(root.right);
    
    digits[root.val]--;
  }
    
  public int pseudoPalindromicPaths (TreeNode root) {
    digits = new int[10];
    ans = 0;
    
    dfs(root);
    return ans;
  }
}