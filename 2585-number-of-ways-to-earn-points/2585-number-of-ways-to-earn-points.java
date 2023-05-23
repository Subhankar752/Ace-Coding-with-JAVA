class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        int mod = (int)1e9 + 7, dp[] = new int[target + 1];
        dp[0] = 1;
        for (int[] t : types)
            for (int i = target; i > 0; --i)
                for (int k = 1; k <= t[0] && i - t[1] * k >= 0; ++k)
                    dp[i] = (dp[i] + dp[i - t[1] * k]) % mod;
        return dp[target];
    }
}