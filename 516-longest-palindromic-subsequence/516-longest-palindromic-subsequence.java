class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String rev = reverse(s);
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0 ; i < n + 1 ; i++){
            for(int j = 0 ; j < n + 1 ; j++){
                if(i == 0 || j ==0){
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int i = 1 ; i < n + 1 ; i++){
            for(int j = 1 ; j < n + 1 ; j++){
                char c1 = s.charAt(i - 1);
                char c2 = rev.charAt(j - 1);
                if(c1 == c2){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
    public String reverse(String st){
        String ans = "";
        int n = st.length();
        
        for(int i = n - 1 ; i >= 0 ; i--){
            ans += st.charAt(i);
        }
        
        return ans;
    }
}