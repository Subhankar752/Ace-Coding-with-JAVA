class Solution {

    class DSU {
        int[] parent;
        int[] rank;
        int con;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            con = n;

            for (int i = 0; i < n + 1; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int findParent(int x) {
            if (x == parent[x]) {
                return x;
            }

            return parent[x] = findParent(parent[x]);
        }

        public boolean union(int x, int y) {
            int parx = findParent(x);
            int pary = findParent(y);

            if (parx == pary) {
                return false;
            }

            if (rank[parx] < rank[pary]) {
                parent[parx] = pary;
            } else if (rank[pary] < rank[parx]) {
                parent[pary] = parx;
            } else {
                parent[parx] = pary;
                rank[pary]++;
            }

            con--;
            return true;
        }

        public boolean isConn() {
            return (con == 1);
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);

        int edgeAdd = 0;

        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        for (int[] edge : edges) {
            int type = edge[0];
            int a = edge[1];
            int b = edge[2];

            switch (type) {
                case 3:
                    if (alice.union(a, b) | bob.union(a, b)) {
                        edgeAdd++;
                    }
                    break;
                case 2:
                    if (bob.union(a, b)) {
                        edgeAdd++;
                    }
                    break;
                case 1:
                    if (alice.union(a, b)) {
                        edgeAdd++;
                    }
                    break;
            }
        }

        return (alice.isConn() && bob.isConn()) ? edges.length - edgeAdd : -1;
    }
}
