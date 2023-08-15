class Solution {

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        Integer[][] dp = new Integer[m][n];

        return f(m - 1, n - 1, s1, s2, dp);
    }

    private int f(int i, int j, String s1, String s2, Integer[][] dp) {
        if (i < 0 && j < 0) return 0;
        if (i < 0) return removeAll(s2, j);
        if (j < 0) return removeAll(s1, i);
        if (dp[i][j] != null) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) return f(i - 1, j - 1, s1, s2, dp);

        int removeFromS1 = f(i - 1, j, s1, s2, dp) + s1.charAt(i);
        int removeFromS2 = f(i, j - 1, s1, s2, dp) + s2.charAt(j);
        return dp[i][j] = Math.min(removeFromS1, removeFromS2);
    }

    private int removeAll(String s1, int ind) {
        int ascii = 0;
        for (int i = 0; i <= ind; i++) {
            ascii += s1.charAt(i);
        }
        return ascii;
    }
}
