class Solution {

    class DSU {
        int[] parent;
        int[] rank;
        int con;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            con = n;

            for (int i = 0; i < n; i++) {
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

    class Edge implements Comparable<Edge> {
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
    }

    public int findMST(int[][] edges, int n, int[] skipEdge, int[] pickEdge) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int[] i : edges) {
            if (i == skipEdge || i == pickEdge) {
                continue;
            }
            pq.add(new Edge(i[0], i[1], i[2]));
        }

        DSU dsu = new DSU(n);
        int cost = 0;

        if (pickEdge != null) {
            dsu.union(pickEdge[0], pickEdge[1]);
            cost += pickEdge[2];
        }

        while (pq.size() > 0) {
            Edge edge = pq.remove();
            boolean can = dsu.union(edge.u, edge.v);
            if (can) {
                cost += edge.wt;
            }
        }

        if (dsu.isConn()) {
            return cost;
        }

        return Integer.MAX_VALUE;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int minCost = findMST(edges, n, null, null);
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int minCostWithoutEdge = findMST(edges, n, edge, null);
            
            if (minCostWithoutEdge > minCost) {
                l1.add(i);
            } else {
                int minCostWithEdge = findMST(edges, n, null, edge);
                if (minCostWithEdge == minCost) {
                    l2.add(i);
                }
            }
        }

        return Arrays.asList(l1, l2);
    }
}
