class Solution {
    int ans = 0;
    List<List<Integer>> list;
    int[] size;
    
    public int countGoodNodes(int[][] edges) {
        list = new ArrayList<>();
        int n = edges.length;
        size = new int[n + 1];
        
        for (int i = 0 ; i <= n ; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] i : edges) {
            int u = i[0];
            int v = i[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        boolean[] vis = new boolean[n + 1];
        solve(0, vis);
        
        for (int i = 0 ; i <= n ; i++) {
            List<Integer> childs = list.get(i);
            Set<Integer> hs = new HashSet<>();
            
            for (int child : childs) {  
                if (size[child] > size[i]) {
                    continue;
                }
                hs.add(size[child]);
            }
            if (hs.size() <= 1) {
                ans++;
            }
        }
        
        return ans;
    }
    
    public int solve(int i, boolean[] vis) {
        vis[i] = true;
        
        int res = 1;
        for (int ele : list.get(i)) {
            if (!vis[ele]) {
                res += solve(ele, vis);
            }
        }
        
        return size[i] = res;
    }
}