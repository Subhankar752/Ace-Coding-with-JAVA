class Solution {
    ArrayList<ArrayList<Integer>> adj;
    int[] ans;

    public int[] countOfPairs(int n, int x, int y) {
        adj = new ArrayList<>();
        ans = new int[n];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= n - 1; i++) {
            adj.get(i).add(i + 1);
            adj.get(i + 1).add(i);
        }

        if (x != y) {
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        for (int i = 1; i <= n; i++) {
            boolean[] vis = new boolean[n + 1];
            bfs(i, vis);
        }

        return ans;
    }

    public void bfs(int i, boolean[] vis) {
        int dist = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int cur = q.remove();
                ArrayList<Integer> childs = adj.get(cur);

                for (int ele : childs) {
                    if (!vis[ele]) {
                        vis[ele] = true;
                        q.add(ele);
                        ans[dist - 1]++;
                    }
                }
            }

            dist++;
        }

        System.out.println();
    }
}
