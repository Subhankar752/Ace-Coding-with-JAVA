class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
      Map<Integer, List<Integer[]>> map = new TreeMap<>();
      
      List<List<Integer>> result = new ArrayList<>();
      
      helper(map, root, 0, 0); 
      
      for (Map.Entry<Integer, List<Integer[]>> temp : map.entrySet()) {
        Collections.sort(temp.getValue(), (a, b) -> {
          if (b[0] == a[0]) {
            return a[1] - b[1];
          }
          return a[0] - b[0]; 
        });
        List<Integer> s = new ArrayList<>();
        for (Integer[] v : temp.getValue()) {
          s.add(v[1]);
        }
        result.add(s);
      }
      
      return result; 
         
    }
  
    public void helper(Map<Integer, List<Integer[]>> map, TreeNode root, int width, int depth) {
      
      if (root == null)
        return;
      
      if (!map.containsKey(width)) {
        map.put(width, new ArrayList<>());
      }
      
      map.get(width).add(new Integer[]{depth, root.val});
      
      helper(map, root.left, width - 1, depth + 1);
      helper(map, root.right, width + 1, depth + 1);
      
    }
}