class Solution {
    public int countNegatives(int[][] grid) {
         int m = grid.length, n = grid[0].length, r = m - 1, c = 0, cnt = 0;
        
        while (r >= 0 && c < n) {
            if (grid[r][c] < 0) {
                --r;
                cnt += n - c;
            }else {
                ++c;
            }
        }
        
        return cnt;
    }
}