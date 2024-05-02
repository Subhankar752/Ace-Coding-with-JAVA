class Solution {
    Integer[][][][] dp;
    int mod = (int) (1e9 + 7);

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new Integer[zero + 1][one + 1][2][limit + 1];
        return (solve(zero - 1, one, limit, 0, 1) % mod + solve(zero, one - 1, limit, 1, 1) % mod) % mod;
    }

    public int solve(int zero, int one, int limit, int prev, int cons) {
        if (dp[zero][one][prev][cons] != null) {
            return dp[zero][one][prev][cons];
        }

        if (zero == 0 && one == 0) {
            return 1;
        }

        int ans = 0;

        if (zero > 0) {
            if (prev == 0 && cons < limit) {
                ans = (ans % mod + solve(zero - 1, one, limit, prev, cons + 1) % mod) % mod;
            } else if (prev == 1) {
                ans = (ans % mod + solve(zero - 1, one, limit, 0, 1) % mod) % mod;
            }
        }

        if (one > 0) {
            if (prev == 1 && cons < limit) {
                ans = (ans % mod + solve(zero, one - 1, limit, prev, cons + 1) % mod) % mod;
            } else if (prev == 0) {
                ans = (ans % mod + solve(zero, one - 1, limit, 1, 1) % mod) % mod;
            }
        }

        return dp[zero][one][prev][cons] = ans;
    }
}
