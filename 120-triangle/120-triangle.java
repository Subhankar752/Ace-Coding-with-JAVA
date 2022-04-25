class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = -1;
            }
        }
        return solve(triangle , 0 , 0 , dp);
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