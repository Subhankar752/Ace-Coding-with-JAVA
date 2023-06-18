class Solution {
    private int[] d = {0, 1, 0, -1, 0};
    
    public int minimumEffortPath(int[][] heights) {
        int lo = 0, hi = 1_000_000;
        while (lo < hi) {
            int effort = lo + (hi - lo) / 2;
            if (isPath(heights, effort)) {
                hi = effort;
            }else {
                lo = effort + 1;
            }
        }
        return lo;
    }
    
    private boolean isPath(int[][] h, int effort) {
        int m = h.length, n = h[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[2]);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            for (int k = 0; k < 4; ++k) {
                int r = x + d[k], c = y + d[k + 1];
                if (0 <= r && r < m && 0 <= c && c < n && effort >= Math.abs(h[r][c] - h[x][y]) && seen.add(r * n + c)) {
                    q.offer(new int[]{r, c});
                }
            } 
        }
        return false;
    }
}