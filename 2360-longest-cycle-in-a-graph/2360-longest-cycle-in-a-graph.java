class Solution {
    int ans = -1;

    public int longestCycle(int[] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = edges.length;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (edges[i] == -1) continue;
            adj.get(i).add(edges[i]);
        }

        boolean[] vis = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                list = new ArrayList<>();
                solve(i, adj, vis, list);
            }
        }

        return ans;
    }

    public void solve(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> list) {

        if (vis[i]) {
            int idx = -1;

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == i) {
                    idx = j;
                    break;
                }
            }
            if (idx == -1) return;

            ans = Math.max(ans, list.size() - idx);
            return;
        }

        vis[i] = true;
        list.add(i);

        for (Integer ele : adj.get(i)) {
            solve(ele, adj, vis, list);
        }
    }
}
