class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
       Set<Integer>[] tree = new HashSet[n];
       Arrays.setAll(tree, o -> new HashSet<>());
       for(int [] e : edges)  {
        tree[e[0]].add(e[1]);
        tree[e[1]].add(e[0]);
       }
       boolean [] visited = new boolean[n];
       return dfs(tree, 0, visited, hasApple)[1];
    }

    int [] dfs(Set<Integer>[] tree, int u, boolean [] visited , List<Boolean> has) {
      if(tree[u].isEmpty()) return new int[]{has.get(u) ? 1 : 0, 0};

      visited[u] = true; 
      int cnt = 0;
      for(int v : tree[u]) {
        if(visited[v]) continue;
        int [] tmp = dfs(tree, v, visited, has);
        cnt += ((tmp[1]+2)*tmp[0]);
      }
      
      return new int[]{Math.min(1, has.get(u) ? 1 : cnt), cnt};
    }
}