class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> g = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int[] e = edges[i];
            g.computeIfAbsent(e[0], m -> new HashMap<>()).put(e[1], succProb[i]);
            g.computeIfAbsent(e[1], m -> new HashMap<>()).put(e[0], succProb[i]);
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a[0]));
        double[] prob = new double[n];
        pq.offer(new double[]{1, start});
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int v = (int)cur[1];
            if (v == end) {
                return cur[0];
            }
            if (cur[0] > prob[v]) {
                prob[v] = cur[0];
                for (var entry : g.getOrDefault(v, Map.of()).entrySet()) {
                    int nb = entry.getKey();
                    double p = entry.getValue();
                    pq.offer(new double[]{cur[0] * p, nb});
                }
            }
        }
        return 0d;
    }
}