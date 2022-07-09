class Solution {
    int mod = (int)Math.pow(10 , 9) + 7;
    public int countHousePlacements(int n) {
        
       int a = 1, b = 1, c = 2, mod = (int)1e9 + 7;
        for (int i = 0; i < n; ++i) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return (int)(1L * b * b % mod);
    }
    public int solve(int n){
       
        long[] dp = new long[n + 1];
        
        if(n == 1)
            return 2;
        
        if(n == 2)
            return 3;
        
        dp[1] = 2;
        dp[2] = 3;
        
        for(int i = 3 ; i <= n ; i++){
            dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod;
        }
        
        return (int)dp[n] % mod;
    }
}