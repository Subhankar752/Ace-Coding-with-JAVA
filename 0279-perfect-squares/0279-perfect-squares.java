class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp = new int[n + 1];
        
        Arrays.fill(dp, -1);
        
        return solve(n);
    }
    
    public int solve(int n) {
        if(n < 4) {
            return n;
        }
        
        if(dp[n] != -1) {
            return dp[n];
        }
        
        int ans = n;
        
        for(int i = 1; i * i <= n ; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + solve(n - square));
        }
        
        return dp[n] = ans;
    }
}