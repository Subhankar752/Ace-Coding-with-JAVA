class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        long res = Long.MAX_VALUE;
        long[] dp = new long[n];
        dp[0] = Math.max(0, k - nums[0]);
        dp[1] = Math.max(0, k - nums[1]);
        dp[2] = Math.max(0, k - nums[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(0, k - nums[i]) + Math.min(Math.min(dp[i - 3], dp[i - 2]), dp[i - 1]);
        }
        return Math.min(Math.min(dp[n - 3], dp[n - 2]), dp[n - 1]);
    }
}