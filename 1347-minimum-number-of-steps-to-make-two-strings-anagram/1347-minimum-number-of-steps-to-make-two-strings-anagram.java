class Solution {

    public int minSteps(String s, String t) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (smap.containsKey(c)) {
                smap.put(c, smap.get(c) + 1);
            } else {
                smap.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (tmap.containsKey(c)) {
                tmap.put(c, tmap.get(c) + 1);
            } else {
                tmap.put(c, 1);
            }
        }

        int ans = 0;

        for (Map.Entry<Character, Integer> m : smap.entrySet()) {
            char key = m.getKey();
            int val1 = m.getValue();

            int val2 = 0;
            if (tmap.containsKey(key)) {
                val2 = tmap.get(key);
            }

            if (val1 > val2) {
                ans += Math.abs(val1 - val2);
            }
        }

        return ans;
    }
}
