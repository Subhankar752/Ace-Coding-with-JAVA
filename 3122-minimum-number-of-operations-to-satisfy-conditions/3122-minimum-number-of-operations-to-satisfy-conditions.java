class Solution {
    int[][] vals;
    Integer[][] dp;

    public int minimumOperations(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        vals = new int[cols][10];
        dp = new Integer[cols][11];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                vals[i][grid[j][i]]++;
            }
        }

        int ans = solve(0, -1, cols, rows);

        return ans;
    }

    public int solve(int colIdx, int prevVal, int cols, int rows) {
        if (colIdx == cols) {
            return 0;
        }
        
        if(dp[colIdx][prevVal + 1] != null) {
            return dp[colIdx][prevVal + 1];
        }

        int val = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            if (prevVal == i) {
                continue;
            }
            
            val = Math.min(val, rows - vals[colIdx][i] + solve(colIdx + 1, i, cols, rows));
        }
        
        return dp[colIdx][prevVal + 1] = val;
    }
}
