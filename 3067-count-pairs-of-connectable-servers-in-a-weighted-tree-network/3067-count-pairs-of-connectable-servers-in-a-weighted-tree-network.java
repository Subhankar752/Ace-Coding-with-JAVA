class Solution {
    List<int[]>[] list;
    int n;

    private int dfs(int parent, int curr, int w, int signalSpeed) {
        int cnt = 0;
        if (w % signalSpeed == 0) cnt++;
        for (int[] e : list[curr]) {
            if (e[0] != parent) {
                cnt += dfs(curr, e[0], w + e[1], signalSpeed);
            }
        }
        return cnt;
    }

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        n = edges.length + 1;
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList();
        }

        for (int[] e : edges) {
            list[e[0]].add(new int[] { e[1], e[2] });
            list[e[1]].add(new int[] { e[0], e[2] });
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int node = 0, pair = 0;
            for (int[] e : list[i]) {
                int cnt = dfs(i, e[0], e[1], signalSpeed);
                pair += node * cnt;
                node += cnt;
            }
            res[i] = pair;
        }
        return res;
    }
}
