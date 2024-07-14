class Solution {
    Integer[][][][] dp;
    int[] hcut;
    int[] vcut;
    
    public int minimumCost(int rows, int cols, int[] hcut, int[] vcut) {
        dp = new Integer[21][21][21][21];
        this.hcut = hcut;
        this.vcut = vcut;
        return solve(0, rows, 0, cols);
    }
    
    public int solve(int si, int ei, int sj, int ej) {
        if ((ei - si) == 1 && (ej - sj) == 1) {
            return 0;
        }
        
        if (dp[si][ei][sj][ej] != null) {
            return dp[si][ei][sj][ej];
        }
        
        int ans = Integer.MAX_VALUE;
        
        //horizontal cut
        for (int i = si + 1 ; i < ei ; i++) {
            int cost = hcut[i - 1] + solve(si, i, sj, ej) + solve(i, ei, sj, ej);
            ans = Math.min(ans, cost);
        }
        
        //vertical cut
        for (int i = sj + 1; i < ej ; i++) {
            int cost = vcut[i - 1] + solve(si, ei, sj, i) + solve(si, ei, i, ej);
            ans = Math.min(ans, cost);
        }
        
        return dp[si][ei][sj][ej] = ans;
    }
}