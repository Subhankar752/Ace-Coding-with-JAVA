class Solution {
    int[] dx = { -1, 0, 1 };
    Integer[][][] dp;

    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new Integer[rows + 1][cols + 1][cols + 1];

        return solve(grid, 0, 0, cols - 1);
    }

    public int solve(int[][] grid, int row, int acol, int bcol) {
        if (dp[row][acol][bcol] != null) {
            return dp[row][acol][bcol];
        }

        int res = 0;
        res += grid[row][acol];
        res += grid[row][bcol];

        int max = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = acol + dx[i];
                int y = bcol + dx[j];

                if (isValid(x, y, grid, row + 1)) {
                    max = Math.max(max, solve(grid, row + 1, x, y));
                }
            }
        }

        res += max;
        return dp[row][acol][bcol] = res;
    }

    public boolean isValid(int colA, int colB, int[][] grid, int row) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row == rows) {
            return false;
        }

        if (colA < 0 || colB < 0 || colA > cols - 1 || colB > cols - 1) {
            return false;
        }

        if (colA >= colB) {
            return false;
        }

        return true;
    }
}
