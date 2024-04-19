class Solution {
    List<List<Integer>> g1 = new ArrayList<>();
    List<List<Integer>> g2 = new ArrayList<>();

    public int minimumTime(int n, int[][] relations, int[] time) {
        for (int i = 0; i <= n; i++) {
            g1.add(new ArrayList<>());
            g2.add(new ArrayList<>());
        }

        int[] indeg = new int[n + 1];
        int[] outdeg = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] i : relations) {
            int u = i[0];
            int v = i[1];

            g1.get(u).add(v);
            indeg[v]++;
            outdeg[u]++;

            g2.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            int cur = q.remove();
            List<Integer> list = g2.get(cur);

            int max = 0;
            for (int i : list) {
                int val = map.get(i);
                max = Math.max(max, val);
            }

            for (int i : g1.get(cur)) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }

            int val = time[cur - 1];
            map.put(cur, val + max);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            ans = Math.max(ans, m.getValue());
        }

        return ans;
    }
}
