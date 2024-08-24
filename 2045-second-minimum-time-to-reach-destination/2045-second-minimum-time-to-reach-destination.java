class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[][] dist = new int[n][2];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currTime = curr[0];
            int node = curr[1];

            for (int adjNode : adj.get(node)) {
                int waitingTime = 0;
                if ((currTime / change) % 2 == 1) {
                    waitingTime = change - (currTime % change);
                }
                int newTime = time + currTime + waitingTime;

                if (dist[adjNode][0] > newTime) {
                    dist[adjNode][1] = dist[adjNode][0];
                    dist[adjNode][0] = newTime;
                    queue.add(new int[]{newTime, adjNode});
                } else if (dist[adjNode][1] > newTime && dist[adjNode][0] < newTime) {
                    dist[adjNode][1] = newTime;
                    queue.add(new int[]{newTime, adjNode});
                }
            }
        }
        return dist[n - 1][1];
    }
}