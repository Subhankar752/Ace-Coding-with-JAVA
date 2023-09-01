class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        
        for(int i = 0 ; i < n + 1 ; i++) {
            dp[i] = (int)1e9;
        }
        
        dp[0] = 0;
        
        for(int i = 0 ; i < n + 1 ; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            
            for(int j = start ; j <= end ; j++) {
                dp[end] = Math.min(dp[end], dp[j] + 1);
            }
        }
        
        if(dp[n] == (int)1e9) {
            return -1;
        }
        
        return dp[n];
    }
}