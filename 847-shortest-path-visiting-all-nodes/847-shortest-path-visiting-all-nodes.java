class Solution {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length, visitedAll = (int)Math.pow(2, N) - 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        for (int i = 0; i < N; i++)
            pq.offer(new int[]{i, 1 << i, 1});
        
        Set<String> duplicates = new HashSet<>();
        
        while (!pq.isEmpty())
        {
            int[] vals = pq.poll();
            int id = vals[0], visited = vals[1], length = vals[2];
            
            
            if (!duplicates.add(id + "_" + visited))
                continue;
            
            if (visited == visitedAll)
                return length-1;
            
            for (int i : graph[id])
                pq.offer(new int[]{i, visited | (1 << i), length+1});   
        }
        
        return -1;
    }
}