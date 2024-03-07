class Solution {

    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] a = new int[rows][cols];

        a[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            a[i][0] = a[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < cols; i++) {
            a[0][i] = a[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                a[i][j] = grid[i][j] + a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1];
            }
        }
        

        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] <= k) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
