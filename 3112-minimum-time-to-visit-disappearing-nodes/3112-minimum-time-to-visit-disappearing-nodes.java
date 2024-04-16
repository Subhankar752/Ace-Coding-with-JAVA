class Solution {

    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] minimumTime(int n, int[][] edges, int[] dpr) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : edges) {
            int u = i[0];
            int v = i[1];
            int wt = i[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        boolean[] vis = new boolean[n];
        pq.add(new Pair(0, 0));
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE;
        }

        d[0] = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int node = p.node;
            int dist = p.dist;
            if(vis[node]) {
                continue;
            }
            vis[node] = true;

            for (Pair pair : adj.get(node)) {
                if (dist + pair.dist < d[pair.node] && dist + pair.dist < dpr[pair.node]) {
                    d[pair.node] = dist + pair.dist;
                    pq.add(new Pair(pair.node, d[pair.node]));
                }
            }
        }

        for (int i = 0; i < d.length; i++) {
            if (d[i] == Integer.MAX_VALUE) {
                d[i] = -1;
            }
        }
        
        return d;
    }
}
