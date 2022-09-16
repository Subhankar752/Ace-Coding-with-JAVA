class Solution {
    public int helper(int i, int j, int k, int[] nums, int[] mult, Integer[][] dp){
    if(k == mult.length){
        return 0;
    }   
        
    if(dp[i][k] != null){
        return dp[i][k];
    }
        
    int val1 = helper(i + 1 , j , k + 1 , nums , mult , dp) + nums[i] * mult[k];
    int val2 = helper(i , j - 1 , k + 1 , nums , mult , dp) + nums[j] * mult[k];  
        
    return dp[i][k] = Math.max(val1 , val2);
}
public int maximumScore(int[] nums, int[] multipliers) {
    Integer[][] dp = new Integer[nums.length][multipliers.length];
    return helper(0 , nums.length - 1 , 0 , nums , multipliers , dp);
}
}