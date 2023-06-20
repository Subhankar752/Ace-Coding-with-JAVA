class Solution {
    int[][] dp;
    int[] dirx = { -1, 0, 1, 0 };
    int[] diry = { 0, 1, 0, -1 };
    int m = (int) (1e9 + 7);

    public int countPaths(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans = ((ans % m) + (solve(i, j, grid) % m)) % m;
            }
        }

        return ans;
    }

    public int solve(int i, int j, int[][] grid) {
        int res = 1;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        for (int k = 0; k < 4; k++) {
            int x = i + dirx[k];
            int y = j + diry[k];

            if (isValid(x, y, grid, i, j)) {
                res = ((res % m) + (solve(x, y, grid) % m)) % m;
            }
        }

        return dp[i][j] = res;
    }

    public boolean isValid(int i, int j, int[][] grid, int x, int y) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) return false;

        if (grid[x][y] > grid[i][j]) return true;

        return false;
    }
}
