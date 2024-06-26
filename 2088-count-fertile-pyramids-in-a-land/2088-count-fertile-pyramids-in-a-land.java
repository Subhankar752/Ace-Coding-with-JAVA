class Solution {

    public int countPyramids(int[][] grid) {
        int[][] inverseGrid = inverse(grid);
        return helper(grid) + helper(inverseGrid);
    }

    public int helper(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] > 0) {
                    grid[i][j] = Math.min(Math.min(grid[i - 1][j], grid[i - 1][j - 1]), grid[i - 1][j + 1]) + 1;
                    ans += grid[i][j] - 1;
                }
            }
        }
        return ans;
    }

    public int[][] inverse(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] g = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = grid[m - i - 1][j];
            }
        }
        return g;
    }
}
