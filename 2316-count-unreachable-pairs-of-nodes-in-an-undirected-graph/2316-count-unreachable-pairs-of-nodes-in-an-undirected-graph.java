class Solution {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public long countPairs(int n, int[][] edges) {
        long ans = 0;
        
        for(int i = 0 ; i < n ; i++)
            adj.add(new ArrayList<>());
        
        for(int[] i : edges){
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[n];
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                HashSet<Integer> hs = new HashSet<>();
                dfs(i , vis , hs);
                res.add(hs.size());
            }
        }
        
        long sum = 0;
        long curSum = 0;
        for(int i : res)
            sum += i;
        
        for(int i = 0 ; i < res.size() - 1 ; i++){
            curSum += res.get(i);
            ans += (sum - curSum) * res.get(i);
        }
        
        return ans;
    }
    
    public void dfs(int i , boolean[] vis , HashSet<Integer> hs){
        
        vis[i] = true;
        hs.add(i);
        
        for(int ele : adj.get(i)){
            if(!vis[ele])
                dfs(ele , vis , hs);
        }
    }
}