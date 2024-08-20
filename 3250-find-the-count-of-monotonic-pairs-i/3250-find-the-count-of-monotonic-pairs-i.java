class Solution {
    int mod = (int) (1e9 + 7);
    Integer[][][] dp;

    public int countOfPairs(int[] nums) {
        dp = new Integer[nums.length + 1][51][51];
        return solve(0, nums, 0, 50);
    }

    public int solve(int idx, int[] a, int p1, int p2) {
        if (idx == a.length) {
            return 1;
        }

        if (dp[idx][p1][p2] != null) {
            return dp[idx][p1][p2];
        }

        int ans = 0;
        for (int i = 0; i <= a[idx]; i++) {
            int a1 = i;
            int a2 = a[idx] - a1;
            if (a1 >= p1 && a2 <= p2) {
                ans = ((ans % mod) + (solve(idx + 1, a, a1, a2) % mod)) % mod;
            }
        }

        return dp[idx][p1][p2] = ans % mod;
    }
}
