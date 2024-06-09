class Solution {
    int ans;
    int n;
    int[] a;
    Integer[][][] dp;

    public int maximumLength(int[] nums, int k) {
        ans = 1;
        n = nums.length;
        a = nums;
        dp = new Integer[n + 1][n + 1][k + 1];

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, solve(i, i + 1, k));
        }

        return ans;
    }

    public int solve(int prev, int i, int k) {
        if (k < 0) {
            return 0;
        }
        if (i == n) {
            return 1;
        }

        if (dp[prev][i][k] != null) {
            return dp[prev][i][k];
        }

        //not take
        int op = 0;
        op = Math.max(op, solve(prev, i + 1, k));

        //take
        int op2 = -1;
        if (a[i] == a[prev]) {
            op = Math.max(op, 1 + solve(i, i + 1, k));
        } else {
            op = Math.max(op, 1 + solve(i, i + 1, k - 1));
        }

        return dp[prev][i][k] = op;
    }
}
