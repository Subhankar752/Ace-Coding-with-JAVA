class Solution {
    int[] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[1001];

        return solve(0, arr, k);
    }

    public int solve(int i, int[] a, int k) {
        int max = 0;
        int ans = 0;

        if (dp[i] != 0) {
            return dp[i];
        }

        for (int j = i; j < Math.min(a.length, i + k); j++) {
            max = Math.max(max, a[j]);
            int temp = (max * (j - i + 1)) + solve(j + 1, a, k);

            ans = Math.max(ans, temp);
        }

        return dp[i] = ans;
    }
}
