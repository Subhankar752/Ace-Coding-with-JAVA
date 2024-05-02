class Solution {
    static int l;
    static int dp[][][][];
    static int mod = 1000000007;

    static int helper(int zero, int one, int conseq, int prev) {
        if (dp[zero][one][prev][conseq] != -1) return dp[zero][one][prev][conseq] % mod;

        int ans = 0;
        if (zero == 0 && one == 0) return 1;
        if (zero > 0) {
            if (prev == 0 && conseq < l) {
                ans = ans + helper(zero - 1, one, conseq + 1, 0);
            }
            if (prev == 1) ans = ans + helper(zero - 1, one, 1, 0);
        }
        if (one > 0) {
            if (prev == 1 && conseq < l) {
                ans = ans + helper(zero, one - 1, conseq + 1, 1);
            }
            if (prev == 0) ans = ans + helper(zero, one - 1, 1, 1);
        }
        return dp[zero][one][prev][conseq] = ans % mod;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        l = limit;
        dp = new int[zero + 1][one + 1][2][l + 1];
        for (var a : dp) for (var b : a) for (var c : b) Arrays.fill(c, -1);
        int a = helper(zero - 1, one, 1, 0) % mod;
        int b = helper(zero, one - 1, 1, 1) % mod;
        return (a + b) % mod;
    }
}
