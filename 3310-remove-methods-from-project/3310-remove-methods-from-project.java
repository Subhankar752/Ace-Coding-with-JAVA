class Solution {

    private void dfs(boolean[] sup, int curr, Map<Integer, List<Integer>> map, boolean vis[]) {
        vis[curr] = true;
        sup[curr] = true;

        for (int child : map.getOrDefault(curr, new ArrayList<>())) {
            if (!vis[child]) dfs(sup, child, map, vis);
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int in[] : invocations) {
            int u = in[0], v = in[1];

            if (!map.containsKey(u)) map.put(u, new ArrayList<>());
            map.get(u).add(v);
        }

        boolean[] sup = new boolean[n];
        dfs(sup, k, map, new boolean[n]);

        boolean nonSupFlag = false;
        for (int i = 0; i < n; i++) {
            if (!sup[i]) {
                for (int child : map.getOrDefault(i, new ArrayList<>())) {
                    if (sup[child]) {
                        nonSupFlag = true;
                        break;
                    }
                }
            }
            if (nonSupFlag) break;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nonSupFlag || !sup[i]) {
                res.add(i);
            }
        }

        return res;
    }
}
