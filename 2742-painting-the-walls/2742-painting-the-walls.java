class Solution {
    int[][] dp;

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        dp = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, n, cost, time);
    }

    public int solve(int i, int size, int[] cost, int[] time) {
        if (size <= 0) return 0;

        if (i > cost.length - 1) return 900000000;

        if (dp[i][size] != -1) return dp[i][size];

        int notTake = solve(i + 1, size, cost, time);

        int take = solve(i + 1, size - time[i] - 1, cost, time) + cost[i];

        return dp[i][size] = Math.min(take, notTake);
    }
}
