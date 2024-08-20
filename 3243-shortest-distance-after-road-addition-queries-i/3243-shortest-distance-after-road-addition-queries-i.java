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
        }
        int[] ans = new int[queries.length];
        int idx = 0;
        for (int[] i : queries) {
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            ans[idx++] = solve(n);
        }

        return ans;
    }

    public int solve(int n) {
        boolean[] vis = new boolean[n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        vis[0] = true;

        while (!q.isEmpty()) {
            Pair cur = q.remove();
            int val = cur.val;
            int dist = cur.dis;
            
            if (val == n - 1) {
                return dist;
            }
            List<Integer> list = adj.get(val);
            for (int ele : list) {
                if (!vis[ele]) {
                    vis[ele] = true;
                    q.add(new Pair(ele, dist + 1));
                }
            }
        }

        return -1;
    }
}
