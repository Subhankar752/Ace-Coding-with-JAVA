class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
            adj.add(new ArrayList<>());
        for(int[] i : edges){
            int from = i[0];
            int to = i[1];
            adj.get(to).add(from);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
            ans.add(new ArrayList<>());
        HashSet<Integer> hs = new HashSet<>();
        boolean[] vis = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            vis = new boolean[n];
            hs = new HashSet<>();
            dfs(adj , i , vis , hs);
            List<Integer> temp = new ArrayList<>();
            for(int ele : hs)
                temp.add(ele);
            Collections.sort(temp);
            ans.set(i , temp);
        }
        return ans;
    }
    public void dfs(List<List<Integer>> adj , int i , boolean[] vis , HashSet<Integer> hs){
        vis[i] = true;
        for(int ele : adj.get(i)){
            if(!vis[ele])
            {
                hs.add(ele);
                dfs(adj , ele , vis , hs);
            }
        }
    }
}
// class Solution {
//     public List<List<Integer>> getAncestors(int n, int[][] edges) {
//         List<List<Integer>> ancestorsList = new ArrayList();  // List to store the final ancestorsList
//         for (int i=0; i<n; i++)
//             ancestorsList.add(new ArrayList<>());             // Add empty array list for all nodes

//         LinkedList<Integer>[] adj = new LinkedList[n];        // Adjacency mapping
//         for (int i=0; i<n; i++)
//             adj[i] = new LinkedList();                           // Initialize adjacency as lists
//         for (int[] edge : edges)
//             adj[edge[1]].add(edge[0]);                           // Note that we are adding the edge in opposite direction

//         for (int child=0; child<n; child++) {                 // For each node
//             boolean[] visited = new boolean[n];                  // Array to store the visited nodes
//             dfs(ancestorsList, visited, adj, child, child);      // DFS
//             Collections.sort(ancestorsList.get(child));          // Sort in ascending order
//         }

//         return ancestorsList;                                 // Return ancestorsList
//     }

//     private void dfs(List<List<Integer>> ancestorsList, boolean[] visited,
//                      LinkedList<Integer>[] adj, int parent, int child) {
//         visited[parent] = true;                                 // Set current node as visited
//         for (int next : adj[parent]) {                           // For each edge
//             if (!visited[next]) {                                  // If not visited already
//                 ancestorsList.get(child).add(next);                // Add the current node as ancestor to child 
//                 dfs(ancestorsList, visited, adj, next, child);     // Recursion                  
//             }
//         }
//     }
// }