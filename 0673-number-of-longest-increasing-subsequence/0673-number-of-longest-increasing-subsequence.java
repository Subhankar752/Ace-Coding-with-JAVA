class Solution {

    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;

                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLength) {
                ans += count[i];
            }
        }
        return ans;
    }
}
