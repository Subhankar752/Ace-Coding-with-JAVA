class Solution {
    List<List<Integer>> adj;
    int ans = 0;
    int[] values;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        adj = new ArrayList<>();
        ans = 0;
        this.values = values;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        solve(0, -1, k);
        return ans;
    }

    public long solve(int node, int parent, int k) {
        long sum = values[node];

        for (int ele : adj.get(node)) {
            if (ele != parent) {
                sum += solve(ele, node, k);
            }
        }

        if (sum % k == 0) {
            ans++;
            sum = 0;
        }

        return sum;
    }
}
