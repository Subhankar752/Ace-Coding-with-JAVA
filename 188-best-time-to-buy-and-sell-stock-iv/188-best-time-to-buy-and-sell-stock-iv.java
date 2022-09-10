class Solution {
    public int maxProfit(int k, int[] prices) {
         int n = prices.length;
        if(n == 0)
            return 0;
        int[][] dp = new int[k + 1][n];
        for(int i = 0 ; i < k + 1 ; i++)
            dp[i][0] = 0;
        for(int i = 0 ; i < n  ; i++){
            dp[0][i] = 0;
        }
        for(int i = 1 ; i < k + 1 ; i++){
            for(int j = 1 ; j < n ; j++){
                int maxSoFar = 0;
                for(int m = 0 ; m < j ; m++){
                    maxSoFar = Math.max(maxSoFar , prices[j] - prices[m] + dp[i - 1][m]);
                }   
                dp[i][j] = Math.max(maxSoFar , dp[i][j - 1]);
            }
        }
        return dp[k][n - 1];
    }
}