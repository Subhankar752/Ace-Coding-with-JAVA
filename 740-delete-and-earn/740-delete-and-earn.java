class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i : nums)
            max = Math.max(max , i);
        int dp[] = new int[max + 2];
        for(int i : nums)
            dp[i] += i;
        for(int i = 2 ; i < max + 2 ; ++i)
        {
            dp[i] = Math.max(dp[i - 2] + dp[i] , dp[i - 1]);
        }
        return dp[max + 1];
    }
}