class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int ans = 0;
        HashSet<Character> hs = new HashSet<>();
        
        for (j = 0 ; j < s.length() ; j++) {
            char ch = s.charAt(j);
            
            while(hs.contains(ch)) {
                hs.remove(s.charAt(i));
                i++;
            }
            
            hs.add(ch);
            
            ans = Math.max(ans , j - i + 1);
        }
        
        return ans;
    }
}