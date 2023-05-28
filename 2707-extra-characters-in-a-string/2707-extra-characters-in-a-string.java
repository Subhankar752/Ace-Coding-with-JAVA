class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        // Create set for dictionary for O(1) search in dictionary.
        for (String word : dictionary) set.add(word); 
        
        // Memoization array, with Integer.MAX_VALUE as default value.
        int[] dp = new int[s.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // start with index 0.
        return split(s, 0, dp, set);
    }
    
    private int split(String s, int index, int[] dp, Set<String> dictionary) {
        // if index reached at the end of the string there no extra character remaining.
        if (index >= s.length()) return 0;
        
        // if dictionary contains word for subtring from index to length.
        // There is no extra character.
        if (dictionary.contains(s.substring(index, s.length()))) return 0;
        
        // if dp[index] is not default value, 
        // we have already calculated result for this index.
        if (dp[index] != Integer.MAX_VALUE) return dp[index];
        
        // Default value can be all the characters of subtring.
        int min = s.length() - index;
        // check for all possible substring from current index
        for (int i = index + 1; i <= s.length(); i++) {
            // if this substring is in dictionary there are zero characters.
            // else all characters of this substring are remaining.
            int count = dictionary.contains(s.substring(index, i)) ? 0 : i - index;
            // check for second half after split.
            count += split(s, i, dp, dictionary);
            // updated the minimum value.
            min = Math.min(min, count);
        }
        
        // update dp[index] with current min.
        dp[index] = min;
        return min;
    }
}