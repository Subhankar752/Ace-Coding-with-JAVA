class Solution {

    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[][] dp = new int[10001][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = (nums[i] + nums[j]) % k;
                dp[i][diff] = dp[j][diff] + 1;
                ans = Math.max(ans, dp[i][diff]);
            }
        }
        return ans + 1;
    }
}
