class Solution {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        for(int i = 0 ; i <= n ; i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j)
                    continue;
                if(isConnected[i][j] == 1){
                    adj.get(i + 1).add(j + 1);
                }
            }
        }
        
        int ans = 0;
        boolean[] vis = new boolean[n + 1];
        for(int i = 1 ; i <= n ; i++){
            if(!vis[i]){
                ans++;
                dfs(i , vis);
            }
        }
        return ans;
    }
    public void dfs(int i , boolean[] vis){
        vis[i] = true;
        for(int k : adj.get(i)){
            if(!vis[k])
                dfs(k , vis);
        }
    }
}