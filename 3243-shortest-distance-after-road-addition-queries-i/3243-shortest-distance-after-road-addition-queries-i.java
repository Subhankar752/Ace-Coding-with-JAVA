class Solution {

    class Pair {
        int val;
        int dis;

        Pair(int val, int dis) {
            this.val = val;
            this.dis = dis;
        }
    }

    List<List<Integer>> adj;

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            adj.get(i).add(i + 1);
            // adj.get(i + 1).add(i);
        }
        int[] ans = new int[queries.length];
        int idx = 0;
        for (int[] i : queries) {
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            // adj.get(v).add(u);
            boolean[] vis = new boolean[n];
            int[] dis = new int[n];
            solve(0, dis, vis);
            ans[idx++] = dis[n - 1];
        }

        return ans;
    }

    public void solve(int j, int[] dis, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        vis[0] = true;
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        while (!q.isEmpty()) {
            Pair cur = q.remove();
            int val = cur.val;
            int dist = cur.dis;
            List<Integer> list = adj.get(val);
            for (int ele : list) {
                if (!vis[ele]) {
                    vis[ele] = true;
                    q.add(new Pair(ele, dist + 1));
                    dis[ele] = Math.min(dist + 1, dis[ele]);
                }
            }
        }
        
    }
}
