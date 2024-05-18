class Solution {
    int max = 0;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] result = new int[n - 1];
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], k -> (new ArrayList<>())).add(e[1]);
            graph.computeIfAbsent(e[1], k -> (new ArrayList<>())).add(e[0]);
        }

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subtree = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subtree.add(j + 1);
                }
            }

            int edge_number = 0;
            for (int[] e : edges) {
                if (subtree.contains(e[0]) && subtree.contains(e[1])) edge_number++;
            }

            if (edge_number < 1 || subtree.size() != edge_number + 1) continue;

            Set<Integer> visited = new HashSet<>();
            max = 0;
            visited.add(subtree.get(0));
            dfs(subtree.get(0), graph, subtree, visited);
            result[max - 1]++;
        }

        return result;
    }

    private int dfs(int current, Map<Integer, List<Integer>> graph, List<Integer> subtree, Set<Integer> visited) {
        int m1 = 0;
        int m2 = 0;

        for (int neighbor : graph.get(current)) {
            if (!visited.contains(neighbor) && subtree.contains(neighbor)) {
                visited.add(neighbor);
                int depth = dfs(neighbor, graph, subtree, visited);
                if (depth > m1) {
                    m2 = m1;
                    m1 = depth;
                } else if (depth > m2) m2 = depth;
            }
        }

        max = Math.max(max, m1 + m2);
        return m1 + 1;
    }
}
