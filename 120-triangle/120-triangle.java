class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        
        for(int i = 0 ; i < n ; i++){
            int m = triangle.get(i).size();
            for(int j = 0 ; j < m ; j++){
                dp[i][j] = triangle.get(i).get(j);
            }
        }
        
        for(int i = 1 ; i < n ; i++){
            dp[i][0] = dp[i][0] + dp[i - 1][0];
        }
        for(int i = 1 ; i < n ; i++){
            int size = triangle.get(i).size();
            for(int j = 1 ; j < n ; j++){
                if(j == size - 1){
                    dp[i][j] = dp[i][j] + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = dp[i][j] + Math.min(dp[i - 1][j] , dp[i - 1][j - 1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++)
            ans = Math.min(ans , dp[n - 1][i]);
        return ans;
    }
    public int solve(List<List<Integer>> a , int i , int j , int[][] dp){
        if(i == a.size()){
            return 0;
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        return dp[i][j] = a.get(i).get(j) + Math.min(solve(a , i + 1 , j , dp) , solve(a , i + 1 , j + 1 , dp));
    }
}