class Solution {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for(int i = 0 ; i < n ; i++)
            adj.add(new ArrayList<Integer>());
        for(List<Integer> i : connections){
            int u = i.get(0);
            int v = i.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int timer = 0;
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == 0){
                dfs(i , -1 , vis , tin , low , timer);
            }
        }
        return ans;
    }
    public void dfs(int node , int parent , int[] vis , int[] tin , int[] low , int timer){
        vis[node] = 1;
        low[node] = tin[node] = timer++;
        for(int it : adj.get(node)){
            if(it == parent)
                continue;
            if(vis[it] == 0){
                dfs(it , node , vis , tin , low , timer);
                low[node] = Math.min(low[node] , low[it]);
                if(low[it] > tin[node]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(it);
                    temp.add(node);
                    ans.add(temp);
                }
            }
            else{
                low[node] = Math.min(low[node] , tin[it]);
            }
        }
    }
}