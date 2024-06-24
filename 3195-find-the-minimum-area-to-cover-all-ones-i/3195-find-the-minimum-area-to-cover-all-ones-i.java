class Solution {

    public int minimumArea(int[][] grid) {
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int topRow = 0;
        boolean flag = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    topRow = i;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        int botRow = 0;
        flag = false;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    botRow = i;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        int leftCol = 0;
        flag = false;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (grid[j][i] == 1) {
                    leftCol = i;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        int rightCol = 0;
        flag = false;
        for (int i = cols - 1; i >= 0; i--) {
            for (int j = 0; j < rows; j++) {
                if (grid[j][i] == 1) {
                    rightCol = i;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        return (Math.abs(topRow - botRow) + 1) * (Math.abs(leftCol - rightCol) + 1);
    }
}
