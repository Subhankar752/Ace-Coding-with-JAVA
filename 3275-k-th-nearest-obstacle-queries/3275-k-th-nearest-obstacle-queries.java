class Solution {

    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            pq.add(sum);
            
            if (pq.size() > k) {
                pq.poll();
            }
            
            res[i] = (pq.size() == k) ? pq.peek() : -1;
        }

        return res;
    }
}
