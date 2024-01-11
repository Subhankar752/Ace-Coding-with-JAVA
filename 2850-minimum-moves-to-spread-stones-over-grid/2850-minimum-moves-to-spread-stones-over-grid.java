class Solution {
    int ans = Integer.MAX_VALUE;

    public int minimumMoves(int[][] grid) {
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    flag = true;
                }
            }
        }

        if (!flag) {
            return 0;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    for (int ni = 0; ni < 3; ni++) {
                        for (int nj = 0; nj < 3; nj++) {
                            if (grid[ni][nj] > 1) {
                                int diff = Math.abs(i - ni) + Math.abs(j - nj);
                                grid[ni][nj]--;
                                grid[i][j]++;

                                ans = Math.min(ans, diff + minimumMoves(grid));

                                grid[ni][nj]++;
                                grid[i][j]--;
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}
