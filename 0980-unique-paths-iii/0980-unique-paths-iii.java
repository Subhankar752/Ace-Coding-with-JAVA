class Solution {
    int ans;
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public int uniquePathsIII(int[][] grid) {
        ans = 0;
        int empty = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int si = -1;
        int ei = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                }
                if (grid[i][j] == 1) {
                    si = i;
                    ei = j;
                    empty++;
                }
            }
        }
        boolean[][] vis = new boolean[rows][cols];
        dfs(si, ei, grid, rows, cols, vis, empty);
        return ans;
    }

    public void dfs(int i, int j, int[][] grid, int rows, int cols, boolean[][] vis, int empty) {
        if (grid[i][j] == 2) {
            if (empty == 0) {
                ans++;
            } else {
                return;
            }
        }

        vis[i][j] = true;
        empty--;

        for (int k = 0; k < 4; k++) {
            if (isValid(i + dx[k], j + dy[k], grid, rows, cols, vis)) {
                dfs(i + dx[k], j + dy[k], grid, rows, cols, vis, empty);
            }
        }

        empty++;
        vis[i][j] = false;
    }

    public boolean isValid(int i, int j, int[][] grid, int rows, int cols, boolean[][] vis) {
        if (i < 0 || j < 0 || i > rows - 1 || j > cols - 1) {
            return false;
        }

        if (vis[i][j]) {
            return false;
        }

        if (grid[i][j] == -1) {
            return false;
        }

        return true;
    }
}
