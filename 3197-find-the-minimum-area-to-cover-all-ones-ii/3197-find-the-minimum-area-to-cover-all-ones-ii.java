class Solution {
    int[][] grid;

    public int minimumSum(int[][] grid) {
        this.grid = grid;
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = Integer.MAX_VALUE;

        /*
        -------------
        |    (1)    |
        |           |
        -------------
        | (2) | (3) |
        |     |     |
        -------------
        */
        for (int i = 0; i < rows; i++) {
            int one = findArea(0, i, 0, cols - 1);
            for (int j = 0; j < cols; j++) {
                int two = findArea(i + 1, rows - 1, 0, j);
                int three = findArea(i + 1, rows - 1, j + 1, cols - 1);
                ans = Math.min(ans, (one + two + three));
            }
        }

        /*
        -------------
        |     | (2) |
        |     |     |
          (1) -------
        |     |     |
        |     | (3) |
        -------------
        */
        for (int j = 0; j < cols; j++) {
            int one = findArea(0, rows - 1, 0, j);
            for (int i = 0; i < rows; i++) {
                int two = findArea(0, i, j + 1, cols - 1);
                int three = findArea(i + 1, rows - 1, j + 1, cols - 1);
                ans = Math.min(ans, (one + two + three));
            }
        }

        /*
        -------------
        |     |     |
        | (2) |     |
        ------- (1) |
        |     |     |
        | (3) |     |
        -------------
        */
        for (int j = cols - 1; j >= 0; j--) {
            int one = findArea(0, rows - 1, j, cols - 1);
            for (int i = 0; i < rows; i++) {
                int two = findArea(0, i, 0, j - 1);
                int three = findArea(i + 1, rows - 1, 0, j - 1);
                ans = Math.min(ans, (one + two + three));
            }
        }

        /*
        -------------
        | (2) | (3) |
        |     |     |
        ------------
        |           |
        |    (1)    |
        -------------
        */
        for (int i = rows - 1; i >= 0; i--) {
            int one = findArea(i, rows - 1, 0, cols - 1);
            for (int j = 0; j < cols; j++) {
                int two = findArea(0, i - 1, 0, j);
                int three = findArea(0, i - 1, j + 1, cols - 1);
                ans = Math.min(ans, (one + two + three));
            }
        }

        /*
        -------------
        |    (1)    |
        -------------
        |    (2)    |
        -------------
        |    (3)    |
        -------------
        */
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < rows; j++) {
                int one = findArea(0, i, 0, cols - 1);
                int two = findArea(i + 1, j, 0, cols - 1);
                int three = findArea(j + 1, rows - 1, 0, cols - 1);
                ans = Math.min(ans, (one + two + three));
            }
        }

        /*
        -------------
        |   |   |   |
        |   |   |   |
        |(1)|(2)|(3)|
        |   |   |   |
        |   |   |   |
        -------------
        */
        for (int i = 0; i < cols; i++) {
            for (int j = i + 1; j < cols; j++) {
                int one = findArea(0, rows - 1, 0, i);
                int two = findArea(0, rows - 1, i + 1, j);
                int three = findArea(0, rows - 1, j + 1, cols - 1);
                ans = Math.min(ans, (one + two + three));
            }
        }

        return ans;
    }

    public int findArea(int rs, int re, int cs, int ce) {
        int rowStart = Integer.MAX_VALUE;
        int rowEnd = Integer.MIN_VALUE;
        int colStart = Integer.MAX_VALUE;
        int colEnd = Integer.MIN_VALUE;
        boolean flag = false;

        for (int i = rs; i <= re; i++) {
            for (int j = cs; j <= ce; j++) {
                if (grid[i][j] == 1) {
                    flag = true;
                    rowStart = Math.min(rowStart, i);
                    rowEnd = Math.max(rowEnd, i);
                    colStart = Math.min(colStart, j);
                    colEnd = Math.max(colEnd, j);
                }
            }
        }

        if (!flag) {
            return 0;
        }

        return (rowEnd - rowStart + 1) * (colEnd - colStart + 1);
    }
}
