class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length + 1][10000];
        
        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = 0 ; j < 10000 ; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(nums, 0, -1);
    }
    
    public int solve(int[] a, int i, int prev) {
        if (i >= a.length)
            return 0;
        
        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }
        
        int take = 0;
        int notTake = solve(a, i + 1, prev);
        
        if (prev == -1 || a[i] > a[prev]) {
            take = 1 + solve(a, i + 1, i);
        }
        
        return dp[i][prev + 1] = Math.max(take, notTake);
    }
}