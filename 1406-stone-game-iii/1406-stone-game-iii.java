class Solution {
    Integer[][] dp;

    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer[stoneValue.length + 1][2];

        int ans = solve(0, stoneValue, 0, 1);

        if (ans > 0) {
            return "Alice";
        } else if (ans < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public int solve(int i, int[] a, int cur, int turn) {
        if (i >= a.length) {
            return 0;
        }

        if (dp[i][turn] != null) {
            return dp[i][turn];
        }

        int ans = turn == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int score = 0;
        for (int j = i; j < Math.min(a.length, i + 3); j++) {
            if (turn == 1) {
                score += a[j];
                ans = Math.max(ans, score + solve(j + 1, a, cur, 1 - turn));
            } else {
                score -= a[j];
                ans = Math.min(ans, score + solve(j + 1, a, cur, 1 - turn));
            }
        }

        return dp[i][turn] = ans;
    }
}
