class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        int n = words.length;
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = i + 1; j < n ; j++) {
                if(isPrefixAndSuffix(words[i], words[j])) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    public boolean isPrefixAndSuffix(String s1, String s2) {
        return s2.startsWith(s1) && s2.endsWith(s1);
    }
}