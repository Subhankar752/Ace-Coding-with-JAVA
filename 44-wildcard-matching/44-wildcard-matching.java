class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        dp = new Boolean[n][m];
        
        return solve(s , p , n - 1 , m - 1);
    }
    public boolean solve(String s , String t , int i , int j){
        if(i < 0 && j < 0)
            return true;
        if(i >= 0 && j < 0)
            return false;
        if(j >= 0 && i < 0){
            for(int ii = 0 ; ii <= j ; ii++){
                if(t.charAt(ii) != '*')
                    return false;
            }
            return true;
        }
        if(dp[i][j] != null)
            return dp[i][j];
        if(s.charAt(i) == t.charAt(j) || t.charAt(j) == '?'){
            return dp[i][j] = solve(s , t , i - 1 , j - 1);
        }
        if(t.charAt(j) == '*'){
            return dp[i][j] = solve(s , t , i , j - 1) || solve(s , t , i - 1 , j);
        }
        return dp[i][j] = false;
    }
}