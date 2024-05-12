class Solution {
    int[] dp;

    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int ans = n;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, s, n);
    }

    public int solve(int i, String s, int n) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int[] freq = new int[26];
        int ans = n;
        for (int j = i; j < n; j++) {
            char ch = s.charAt(j);
            freq[ch - 'a']++;

            if (balanced(freq)) {
                ans = Math.min(ans, 1 + solve(j + 1, s, n));
            }
        }

        return dp[i] = ans;
    }

    public boolean balanced(int[] freq) {
        int maxfreq = -1;
        int minfreq = 5005;
        for (int i : freq) {
            if (i > 0) {
                minfreq = Math.min(minfreq, i);
                maxfreq = Math.max(maxfreq, i);
            }
        }

        return maxfreq == minfreq;
    }
}
