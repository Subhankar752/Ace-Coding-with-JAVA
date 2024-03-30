class Graph {

    class Pair {
        int node;
        int wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    List<List<Pair>> adj;
    int len;

    public Graph(int n, int[][] edges) {
        len = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : edges) {
            int u = i[0];
            int v = i[1];
            int wt = i[2];
            adj.get(u).add(new Pair(v, wt));
        }
    }

    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int wt = edge[2];
        adj.get(u).add(new Pair(v, wt));
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        int[] dist = new int[len];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Pair(node1, 0));
        dist[node1] = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int node = p.node;
            int wt = p.wt;

            for (Pair pp : adj.get(node)) {
                if (wt + pp.wt < dist[pp.node]) {
                    dist[pp.node] = wt + pp.wt;
                    pq.add(new Pair(pp.node, dist[pp.node]));
                }
            }
        }

        if (dist[node2] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[node2];
    }
}
/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
