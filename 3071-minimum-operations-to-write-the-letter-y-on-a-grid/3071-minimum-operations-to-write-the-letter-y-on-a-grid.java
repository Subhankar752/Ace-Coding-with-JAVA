class Solution {

    public int minimumOperationsToWriteY(int[][] grid) {
        int zero = 0;
        int one = 0;
        int two = 0;
        int ans = Integer.MAX_VALUE;

        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    zero++;
                } else if (grid[i][j] == 1) {
                    one++;
                } else {
                    two++;
                }
            }
        }

        int i = n / 2;
        int j = n / 2;

        int curZero = 0;
        int curOne = 0;
        int curTwo = 0;

        //topLeft
        int x = i;
        int y = j;
        while (x >= 0 && y >= 0) {
            if (grid[x][y] == 0) {
                curZero++;
                zero--;
            } else if (grid[x][y] == 1) {
                curOne++;
                one--;
            } else {
                curTwo++;
                two--;
            }

            x--;
            y--;
        }

        //topRight
        x = i - 1;
        y = j + 1;
        while (x >= 0 && y < n) {
            if (grid[x][y] == 0) {
                curZero++;
                zero--;
            } else if (grid[x][y] == 1) {
                curOne++;
                one--;
            } else {
                curTwo++;
                two--;
            }

            x--;
            y++;
        }

        //bottom
        x = i + 1;
        y = j;
        while (x < n) {
            if (grid[x][y] == 0) {
                curZero++;
                zero--;
            } else if (grid[x][y] == 1) {
                curOne++;
                one--;
            } else {
                curTwo++;
                two--;
            }

            x++;
        }

        //zero
        int val = curOne + curTwo + Math.min(zero + two, zero + one);
        ans = Math.min(ans, val);

        //one
        val = curZero + curTwo + Math.min(one + two, zero + one);
        System.out.println(val);
        ans = Math.min(ans, val);

        //two
        val = curZero + curOne + Math.min(one + two, zero + two);
        ans = Math.min(ans, val);

        return ans;
    }
}
