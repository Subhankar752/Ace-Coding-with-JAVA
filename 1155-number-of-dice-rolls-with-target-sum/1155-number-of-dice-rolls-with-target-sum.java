class Solution {
   int mod = 1000000007;
public int numRollsToTarget(int n, int k, int target) {
    
    
    int [][]dp = new int[n+1][target+1];
    for(int[]a : dp){
        Arrays.fill(a , -1);
    }
    
    return helper(n,k,target,dp);
    
    
}

public int helper(int n , int k , int target , int[][]dp){
    
    if(target == 0 && n == 0)return 1;
    if(target == 0 || n == 0)return 0;
    
    if(dp[n][target] != -1){
        return dp[n][target];
    }
    
    int countways = 0;
    
    for(int i = 1; i<=k; i++){
      
        if(i > target){
            break;
        }
        
        countways+=helper(n-1,k,target-i,dp);
        countways %= mod;
        
        
    }
    
    return dp[n][target] = countways;
}
}