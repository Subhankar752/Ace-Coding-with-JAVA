class Solution {

    class DSU {
        int[] rank;
        int[] parent;
        int[] weights;

        DSU(int n) {
            rank = new int[n];
            parent = new int[n];
            weights = new int[n];
            Arrays.fill(weights, -1);

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findParent(int x) {
            if (parent[x] == x) {
                return x;
            }

            return parent[x] = findParent(parent[x]);
        }

        public void union(int x, int y, int w) {
            int px = findParent(x);
            int py = findParent(y);

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
                rank[px]++;
            }

            int val = weights[px] & weights[py] & w;
            weights[px] = val;
            weights[py] = val;
        }

        public int solve(int x, int y) {
            if (x == y) return 0;

            if (findParent(x) != findParent(y)) return -1;

            return weights[findParent(x)];
        }
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU(n);
        int[] ans = new int[query.length];

        for (int[] i : edges) {
            dsu.union(i[0], i[1], i[2]);
        }

        int k = 0;

        for (int[] i : query) {
            ans[k++] = dsu.solve(i[0], i[1]);
        }

        return ans;
    }
}
