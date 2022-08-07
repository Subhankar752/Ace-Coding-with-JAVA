class Solution {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int cnt;
    
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }    
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i : restricted){
            hs.add(i);
        }
        
        for(int[] i : edges){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        vis[0] = true;
        int ans = 1;
        for(int ele : adj.get(0)){
            if(!vis[ele]){
                cnt = 0;
                dfs(adj , ele , hs , vis);
                ans += cnt;
            }
        }
        return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj , int src , HashSet<Integer> hs , boolean[] vis){
        if(hs.contains(src))
            return;
        vis[src] = true;
        System.out.println(src);
        cnt++;
        
        for(int ele : adj.get(src)){
            if(!vis[ele])
                dfs(adj , ele , hs , vis);
        }
    }
}