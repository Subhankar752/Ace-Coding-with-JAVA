class Solution {

    public int minFlips(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;

        for (int i = 0; i < rows / 2; i++) {
            for (int j = 0; j < cols / 2; j++) {
                int ones = grid[i][j] + grid[i][cols - 1 - j] + grid[rows - 1 - i][j] + grid[rows - 1 - i][cols - 1 - j];
                if (ones == 0 || ones == 4) {
                    continue;
                } else if (ones >= 2) {
                    ans += (4 - ones);
                } else {
                    ans += ones;
                }
            }
        }

        int ones = 0;
        int diff = 0;
        if (rows % 2 == 1) {
            for (int j = 0; j < cols / 2; j++) {
                if (grid[rows / 2][j] == 1 && grid[rows / 2][cols - 1 - j] == 1) {
                    ones++;
                }

                if (grid[rows / 2][j] != grid[rows / 2][cols - 1 - j]) {
                    ans++;
                    diff++;
                }
            }
        }

        if (cols % 2 == 1) {
            for (int i = 0; i < rows / 2; i++) {
                if (grid[i][cols / 2] == 1 && grid[rows - 1 - i][cols / 2] == 1) {
                    ones++;
                }
                if (grid[i][cols / 2] != grid[rows - 1 - i][cols / 2]) {
                    ans++;
                    diff++;
                }
            }
        }

        if (rows % 2 == 1 && cols % 2 == 1 && grid[rows / 2][cols / 2] == 1) {
            ans++;
        }

        if (ones % 2 == 1 && diff == 0) {
            ans += 2;
        }

        return ans;
    }
}
