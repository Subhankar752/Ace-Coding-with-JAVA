class Solution {

    public static int solve(int i, int j, int n, List<Integer> arr, int x, int[][] dp) {
        if (i >= n || j < 0 || i > j) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int case1 = arr.get(i + 1) - arr.get(i) + solve(i + 2, j, n, arr, x, dp);
        int case2 = arr.get(j) - arr.get(j - 1) + solve(i, j - 2, n, arr, x, dp);
        int case3 = x + solve(i + 1, j - 1, n, arr, x, dp);
        
        return dp[i][j] = Math.min(case1, Math.min(case2, case3));
    }

    public int minOperations(String s1, String s2, int x) {
        int[][] dp = new int[501][501];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        List<Integer> diff = new ArrayList<>();
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff.add(i);
            }
        }
        
        if (diff.size() % 2 != 0) {
            return -1;
        }
        
        return solve(0, diff.size() - 1, diff.size(), diff, x, dp);
    }
}
