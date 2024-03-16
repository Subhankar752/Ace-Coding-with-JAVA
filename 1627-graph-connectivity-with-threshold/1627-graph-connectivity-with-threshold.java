class Solution {
    int[] parent;
    int[] rank;

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (rank[x] > rank[y]) {
            rank[x] += rank[y];
            parent[y] = x;
        } else {
            rank[y] += rank[x];
            parent[x] = y;
        }
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            rank[i] = 1;
            parent[i] = i;
        }

        for (int i = threshold + 1; i <= n; i++) {
            int mul = 1;

            while (mul * i <= n) {
                union(i, mul * i);
                mul++;
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            ans.add(find(q[0]) == find(q[1]));
        }

        return ans;
    }
}
