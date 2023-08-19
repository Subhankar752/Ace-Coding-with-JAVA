class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // put all words into a hashset
        // Set<String> set = new HashSet<>(wordDict);
        // return wb(s, set);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        Set<String> wordSet = new HashSet<>(wordDict);
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
    private boolean wb(String s, Set<String> set) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i = 1; i <= len; ++i) {
            if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}