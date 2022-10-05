class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < amount + 1 ; j++){
                dp[i][j] = -1;
            }
        }
        
        int res = solve(coins , amount , 0 , dp);
        
        if(res == 12345678)
            return -1;
        
        return res;
    }
    
    public int solve(int[] coins , int rem , int idx , int[][] dp){
        if(idx == coins.length - 1){
            if(rem % coins[idx] == 0)
                return rem/coins[idx];
            else
                return 12345678;
        }
        
        if(dp[idx][rem] != -1)
            return dp[idx][rem];
        
        int notTake = solve(coins , rem , idx + 1 , dp);
        int take = Integer.MAX_VALUE;
        
        if(coins[idx] <= rem){
            take = 1 + solve(coins , rem - coins[idx] , idx , dp);
        }
        
        return dp[idx][rem] = Math.min(take , notTake);
    }
}