class Solution {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            
            if (map.get(c1) == 1) {
                return i;
            }
        }

        return -1;
    }
}
