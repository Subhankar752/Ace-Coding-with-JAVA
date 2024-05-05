class Solution {

    public int minAnagramLength(String s) {
        int ans = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            min = Math.min(min, m.getValue());
        }

        for (int i = 1; i <= min; i++) {
            if (min % i == 0) {
                ans = Math.min(ans, solve(map, i));
            }
        }

        return ans;
    }

    public int solve(Map<Character, Integer> map, int i) {
        int ans = 0;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            int val = m.getValue();
            if (val % i != 0) {
                return Integer.MAX_VALUE;
            } else {
                ans += val / i;
            }
        }

        return ans;
    }
}
