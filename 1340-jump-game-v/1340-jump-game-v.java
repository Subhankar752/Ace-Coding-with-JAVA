class Solution {

    Integer[] dp;
    
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        dp = new Integer[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, 1 + solve(i, d, arr, n));
        }
        return ans;
    }

    public int solve(int idx, int d, int[] a, int n) {
        int ans = 0;
        
        if (dp[idx] != null) {
            return dp[idx];
        }
        
        for (int i = idx + 1; i <= Math.min(n - 1, idx + d); i++) {
            if (a[i] >= a[idx]) {
                break;
            }
            ans = Math.max(ans, 1 + solve(i, d, a, n));
        }

        for (int i = idx - 1; i >= Math.max(0, idx - d); i--) {
            if (a[i] >= a[idx]) {
                break;
            }
            ans = Math.max(ans, 1 + solve(i, d, a, n));
        }

        return dp[idx] = ans;
    }
}
