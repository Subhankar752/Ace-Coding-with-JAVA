class Solution {
    int[][] dp;
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = -1;
            }
        }
        int a = solve(nums , 0 , nums.length - 1);
        
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        
        int b = sum - a;
        
        if(a >= b)
            return true;
        
        return false;
    }
    public int solve(int[] a , int i , int j){
        if(i > j || i > a.length || j < 0)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int op1 = a[i] + Math.min(solve(a , i + 2 , j) , solve(a , i + 1 , j - 1));
        int op2 = a[j] + Math.min(solve(a , i + 1 , j - 1) , solve(a , i , j - 2));
        
        return dp[i][j] = Math.max(op1 , op2);
    }
}