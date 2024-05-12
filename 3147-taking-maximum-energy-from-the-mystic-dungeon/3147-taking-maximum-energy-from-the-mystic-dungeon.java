class Solution {

    Integer[] dp;
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        dp = new Integer[n];
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(energy, n, k, i));
        }

        return ans;
    }

    public int solve(int[] a, int n, int k, int i) {
        if (i >= n) {
            return 0;
        }
        
        if(dp[i] != null) {
            return dp[i];
        }

        int val = a[i] + solve(a, n, k, i + k);
        return dp[i] = val;
    }
}
