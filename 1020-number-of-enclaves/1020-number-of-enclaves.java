class Solution {

    public int numEnclaves(int[][] grid) {
        int r = grid.length, c = grid[0].length;

        if (r == 0 || c == 0) return 0;
        if (r < 2 || c < 2) return 0;

        // iterating over sides
        for (int i = 0; i < r; i++) {
            // first row
            if (grid[i][0] == 1) dfs(grid, i, 0);
            // last row
            if (grid[i][c - 1] == 1) dfs(grid, i, c - 1);
        }

        for (int i = 0; i < c; i++) {
            // first column
            if (grid[0][i] == 1) dfs(grid, 0, i);
            // last column
            if (grid[r - 1][i] == 1) dfs(grid, r - 1, i);
        }

        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int m, int n) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] == 0) return;
        grid[m][n] = 0;
        dfs(grid, m - 1, n);
        dfs(grid, m, n - 1);
        dfs(grid, m + 1, n);
        dfs(grid, m, n + 1);
    }
}
