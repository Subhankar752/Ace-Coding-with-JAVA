class Solution {
    public int minimumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int res = 0;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            int val = m.getValue();
            if (val % 2 == 0) {
                res += val - 2;
            }
            else {
                res += val - 1;
            }
        }
        
        return s.length() - res;
    }
}