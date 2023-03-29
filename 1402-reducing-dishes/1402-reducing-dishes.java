class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        dp = new Integer[satisfaction.length][501];
        return util(satisfaction , 0 , 1);
    }
    
    private Integer dp[][];
    
    private int util(int []satisfaction, int i, int t) {
        if(i == satisfaction.length) {
            return 0;
        }
        
        if(dp[i][t] != null) 
            return dp[i][t];
        
        return dp[i][t] = Math.max(satisfaction[i] * t + util(satisfaction , i + 1 , t + 1) , util(satisfaction , i + 1 , t));
    }
}