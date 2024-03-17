class Solution {
    int mod = (int) 1e9 + 7;
    int[][][] dp;

    public int sumOfPower(int[] nums, int k) {
        dp = new int[101][101][101];

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int kk = 0; kk < 101; kk++) {
                    dp[i][j][kk] = -1;
                }
            }
        }

        return solve(0, 0, nums, k, 0);
    }

    public int solve(int i, int curSum, int[] nums, int k, int size) {
        if (curSum == k) {
            return (int) (Math.pow(2, nums.length - size) % mod);
        }

        if (i >= nums.length) {
            return 0;
        }

        if (curSum > k) {
            return 0;
        }

        if (dp[i][curSum][size] != -1) {
            return dp[i][curSum][size];
        }

        int val1 = solve(i + 1, curSum + nums[i], nums, k, size + 1) % mod;
        int val2 = solve(i + 1, curSum, nums, k, size) % mod;

        return dp[i][curSum][size] = (val1 + val2) % mod;
    }
}
