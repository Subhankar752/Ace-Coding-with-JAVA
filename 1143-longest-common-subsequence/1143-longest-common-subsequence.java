class Solution {
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return solve(text1, text2, 0, 0);
    }

    public int solve(String s1, String s2, int i, int j) {
        if (i > s1.length() - 1 || j > s2.length() - 1) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);

        if (c1 == c2) {
            return dp[i][j] = 1 + solve(s1, s2, i + 1, j + 1);
        } else {
            return dp[i][j] = Math.max(solve(s1, s2, i, j + 1), solve(s1, s2, i + 1, j));
        }
    }
}
