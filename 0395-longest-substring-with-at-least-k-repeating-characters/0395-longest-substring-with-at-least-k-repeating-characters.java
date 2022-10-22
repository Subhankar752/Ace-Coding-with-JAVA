class Solution {
    public int longestSubstring(String s, int k) {
        int longest = 0;
        if(s.length() > 0 && k==1) {
            return s.length();
        }
        Map<Character,Integer> charMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i),1);
            for(int j = i + 1; j < s.length(); j++) {
                if(charMap.containsKey(s.charAt(j))) {
                    int count = charMap.get(s.charAt(j));
                    count = count+1;
                    charMap.put(s.charAt(j),count);
                    if(count >= k && checkMap(charMap,k)) {
                        longest = Math.max(longest,j-i+1);
                    }
                }
                else {
                charMap.put(s.charAt(j),1);
            }
            }
            charMap.clear();
        }
       return longest;
        
    }
     private static boolean checkMap(Map<Character,Integer> charMap, int k) {
        for(Map.Entry<Character,Integer> entry: charMap.entrySet()) {
            if (entry.getValue() < k) {
                return false;
            }
        }
       return true;
    }
}