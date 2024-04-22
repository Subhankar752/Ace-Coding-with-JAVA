class Solution {

    class Pair {
        int node;
        int wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    List<List<Pair>> adj;

    public boolean[] findAnswer(int n, int[][] edges) {
        adj = new ArrayList<>();

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

        int[] dis1 = shortestPath(0, n);
        int[] dis2 = shortestPath(n - 1, n);
        int shortestLength = dis1[n - 1];
        boolean[] ans = new boolean[edges.length];
        int maxVal = Integer.MAX_VALUE;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            if (dis1[u] + dis2[v] + wt == shortestLength && (dis1[u] != maxVal && dis2[v] != maxVal)) {
                ans[i] = true;
            }

            if (dis1[v] + dis2[u] + wt == shortestLength && (dis1[v] != maxVal && dis2[u] != maxVal)) {
                ans[i] = true;
            }
        }

        return ans;
    }

    public int[] shortestPath(int src, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];

        pq.add(new Pair(src, 0));
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            int node = pair.node;
            int wt = pair.wt;

            if (vis[node]) {
                continue;
            }
            vis[node] = true;

            for (Pair ele : adj.get(node)) {
                if (wt + ele.wt < dis[ele.node]) {
                    dis[ele.node] = wt + ele.wt;
                    pq.add(new Pair(ele.node, dis[ele.node]));
                }
            }
        }

        return dis;
    }
}
