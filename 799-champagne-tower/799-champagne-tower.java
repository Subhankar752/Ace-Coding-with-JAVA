class Solution {
    public double champagneTower(int k, int r, int c) {
        if(k == 0) 
            return 0;
        double[][] dp = new double[r + 1][c + 2];
        dp[0][0] = k;
        
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j <= c ;  j++){
                if(dp[i][j] > 1.0){
                    double spare = dp[i][j] - 1;
                    spare /= 2;
                    dp[i][j] = 1;
                    dp[i+1][j] += spare;
                    dp[i+1][j+1] += spare;
                }
            }
        }
        return Math.min(dp[r][c] , 1.0);
    }
}