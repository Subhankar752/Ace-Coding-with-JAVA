class Solution {
    int mod = (int) (1e9 + 7);
    Integer[][] dp;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        dp = new Integer[101][201];
        return solve(locations, start, finish, fuel);
    }

    public int solve(int[] a, int s, int e, int f) {
        if (f < 0) {
            return 0;
        }

        if (dp[s][f] != null) {
            return dp[s][f];
        }

        int ans = (s == e) ? 1 : 0;
        for (int i = 0; i < a.length; i++) {
            if (s == i) {
                continue;
            }

            ans = (ans % mod + solve(a, i, e, f - Math.abs(a[s] - a[i])) % mod) % mod;
        }

        return dp[s][f] = ans;
    }
}
