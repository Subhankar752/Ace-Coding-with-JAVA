class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        long ans = 0;
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] i : edges){
            int u = i[0];
            int v = i[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                HashSet<Integer> hs = new HashSet<>();
                dfs(i , adj , hs , vis);
                list.add(hs.size());
            }
        }
        //System.out.println(list);
        long sum = 0;
        for(int i : list){
            sum += i;
        }
        
        long curSum = 0;
        
        for(int i = 0 ; i < list.size() - 1 ; i++){
            curSum += list.get(i);
            ans += (sum - curSum) * list.get(i);
        }
        
        return ans;
    }
    public void dfs(int i , ArrayList<ArrayList<Integer>> adj , HashSet<Integer> hs , boolean[] vis){
        vis[i] = true;
        hs.add(i);
        
        for(int ele : adj.get(i)){
            if(!vis[ele]){
                dfs(ele , adj , hs , vis);
            }
        }
    }
}