class Solution {

    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    boolean[][] vis;

    public int shortestBridge(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = Integer.MAX_VALUE;

        vis = new boolean[rows][cols];
        boolean flag = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && vis[i][j] && check(i, j, grid)) {
                    int path = solve(i, j, grid);
                    ans = Math.min(ans, path);
                }
            }
        }

        return ans;
    }

    public int solve(int i, int j, int[][] grid) {
        int c = 0;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        Queue<Pair> q = new LinkedList<>();
        boolean[][] v = new boolean[grid.length][grid[0].length];

        q.add(new Pair(i, j));
        v[i][j] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            c++;

            for (int l = 0; l < size; l++) {
                Pair p = q.remove();

                for (int k = 0; k < 4; k++) {
                    int x = p.a + dx[k];
                    int y = p.b + dy[k];

                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !vis[x][y] && grid[x][y] == 1) {
                        return c - 1;
                    }

                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !v[x][y]) {
                        q.add(new Pair(x, y));
                        v[x][y] = true;
                    }
                }
            }
        }

        return c;
    }

    public boolean check(int i, int j, int[][] grid) {
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !vis[x][y]) {
                return true;
            }
        }

        return false;
    }

    public void dfs(int[][] grid, int i, int j) {
        vis[i][j] = true;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (valid(x, y, grid)) {
                dfs(grid, x, y);
            }
        }
    }

    public boolean valid(int i, int j, int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        if (i < 0 || j < 0 || i > r - 1 || j > c - 1) {
            return false;
        }

        if (vis[i][j]) {
            return false;
        }

        if (grid[i][j] == 0) {
            return false;
        }

        return true;
    }
}
