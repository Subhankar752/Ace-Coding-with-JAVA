class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0] - 1].add(e[1] - 1);
            graph[e[1] - 1].add(e[0] - 1);
        }
        boolean[] visited = new boolean[n]; visited[0] = true;
        double[] prob = new double[n]; prob[0] = 1f;
        Queue<Integer> q = new LinkedList<>(); q.offer(0);
        while (!q.isEmpty() && t-- > 0) {
            for (int size = q.size(); size > 0; size--) {
                int u = q.poll(), nextVerticesCount = 0;
                for (int v : graph[u]) {
                    if (!visited[v]) 
                        nextVerticesCount++;
                }
                for (int v : graph[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                        prob[v] = prob[u] / nextVerticesCount;
                    }
                }
                if (nextVerticesCount > 0) prob[u] = 0; // frog don't stay vertex u, he keeps going to the next vertex
            }
        }
        return prob[target - 1];
    }
}