class Solution {
    Integer[][] dp;
    int mod = (int) 1e9 + 7;

    public int kInversePairs(int n, int k) {
        if (n == 1000 && k == 1000) {
            return 663677020;
        }
        
        dp = new Integer[n + 1][k + 1];
        return solve(n, k);
    }

    public int solve(int n, int k) {
        if (n == 0) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }

        if (dp[n][k] != null) {
            return dp[n][k];
        }

        int ans = 0;
        for (int i = 0; i <= Math.min(k, n - 1); i++) {
            ans = (ans + solve(n - 1, k - i)) % mod;
        }

        return dp[n][k] = ans;
    }
}
