class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new int[n + 1][m + 1];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                dp[i][j] = -1;
            }
        }
        return solve(s , t , n - 1 , m - 1);
    }
    public int solve(String s , String t , int i , int j){
        if(j < 0)
            return 1;
        if(i < 0)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] =  solve(s , t , i - 1 , j - 1) + solve(s , t , i - 1 , j);
        else
            return dp[i][j] = solve(s , t , i - 1 , j);
    }
}