class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n + 1][m + 1];
       
        for(int i = 0 ; i <= n ; i++)
            for(int j = 0 ; j <= m ; j++)
                dp[i][j] = -1;
        
        return solve(word1 , word2 , n , m);
    }
    public int solve(String s , String t , int i , int j){
        if(i == 0)
            return j;
        if(j == 0)
            return i;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s.charAt(i - 1) == t.charAt(j - 1)){
            return dp[i][j] = solve(s , t , i - 1 , j - 1);
        }
        else{
            return dp[i][j] = 1 + Math.min(Math.min(solve(s , t, i - 1 , j) , solve(s , t , i , j - 1)) , solve(s , t , i - 1 , j - 1));
        }
    }
}