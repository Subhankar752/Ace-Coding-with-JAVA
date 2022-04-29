class Solution {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        for(int i = 0 ; i < n ; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i = 0 ; i < n ; i++){
            for(int j : graph[i])
                adj.get(i).add(j);
        }
        
        int[] cols = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(cols , -1);
        for(int i = 0 ; i < n ; i++){
            if(!vis[i])
                if(!dfs(i , cols , vis , 1))
                    return false;
        }
        return true;
    }
    public boolean dfs(int i , int[] cols , boolean[] vis , int color){
        vis[i] = true;
        cols[i] = color;
        for(int ele : adj.get(i)){
            if(!vis[ele]){
                if(!dfs(ele , cols , vis , 1 - color))
                    return false;
            }
            else{
                if(cols[ele] == cols[i])
                    return false;
            }
        }
        return true;
    }
}