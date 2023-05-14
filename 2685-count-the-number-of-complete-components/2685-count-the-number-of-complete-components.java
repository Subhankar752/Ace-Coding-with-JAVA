class Solution {
    int e = 0 , v = 0;
    
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(visited, i, adj);
                e /= 2;
                
                if(e == (v * (v - 1)) / 2)
                    count++;
            }
            
            e = v = 0;
        }
        
        return count;
    }
    
     private void dfs(boolean[] visited, int from, List<List<Integer>> adj) {
        visited[from] = true;
        v++;
         
        for (int to : adj.get(from)) {
            e++;
            
            if (!visited[to]) {
                dfs(visited, to, adj);
            }
        }
    }
}