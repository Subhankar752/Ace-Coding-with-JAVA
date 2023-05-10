class Solution {
    int totalSum;
    
    public int lastStoneWeightII(int[] stones) {
        totalSum = 0;
        for(int i=0; i < stones.length; i++){
            totalSum += stones[i];
        }
        Integer[][] dp = new Integer[stones.length][totalSum+1];
        return dfs(0, 0, stones, dp);
    }
    
    private int dfs(int i, int sum,  int[] stones, Integer[][] dp){
        if(i >= stones.length){           
            return Math.abs(sum-(totalSum-sum));
        }              
        if(dp[i][sum] != null)
            return dp[i][sum];
        return dp[i][sum] = Math.min(dfs(i+1, sum+stones[i], stones, dp), dfs(i+1, sum, stones, dp));
    }
}