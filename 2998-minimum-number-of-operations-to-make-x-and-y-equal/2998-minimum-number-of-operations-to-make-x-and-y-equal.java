class Solution {
    int[] dp;
    public int minimumOperationsToMakeEqual(int x, int y) {
        dp = new int[100000];
        Arrays.fill(dp, -1);
        
        return solve(x, y);
    }
    
    public int solve(int x, int y) {
        if (x == y) {
            return 0;
        }
        
        if (x < y) {
            return y - x;
        }
        
        if (dp[x] != -1) {
            return dp[x];
        }
        
        int ans = Math.abs(x - y);
        
        ans = Math.min(ans, 1 + (x % 5) + solve(x / 5, y));
        ans = Math.min(ans, 1 + (5 - x % 5) + solve(x / 5 + 1, y));
        
        ans = Math.min(ans, 1 + (x % 11) + solve(x / 11, y));
        ans = Math.min(ans, 1 + (11 - x % 11) + solve(x / 11 + 1, y));
        
        return dp[x] = ans;
    }
}