class Solution {
  HashMap<String,Integer>map=new HashMap<>();
  List<TreeNode>list=new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find(root);
      return list;
    }
  public String find(TreeNode root){
    if(root==null){
      return "";
    }
    String left=root.val+"L"+find(root.left); //To check the structure they must be same.
    String right=root.val+"R"+find(root.right);
    
    map.put(left+right,map.getOrDefault(left+right,0)+1);
    if(map.get(left+right)==2){ //check if we find two equal subtree or not.
      list.add(root);
    }
    
    return left+right;
  }
}