class Solution {
    List<List<String>> list;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        list = new ArrayList<>();
        solve(0, words, new ArrayList<>());
        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : letters) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (List<String> i : list) {
            if (qualify(i, charMap)) {
                ans = Math.max(ans, findScore(i, score));
            }
        }

        return ans;
    }

    public int findScore(List<String> list, int[] score) {
        int res = 0;

        for (String s : list) {
            for (char c : s.toCharArray()) {
                int idx = (int) c - 97;
                res += score[idx];
            }
        }

        return res;
    }

    public boolean qualify(List<String> list, Map<Character, Integer> charMap) {
        Map<Character, Integer> map = new HashMap<>();

        for (String s : list) {
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            char key = m.getKey();
            int value1 = m.getValue();

            if (!charMap.containsKey(key)) {
                return false;
            }

            int value2 = charMap.get(key);
            if (value1 > value2) {
                return false;
            }
        }

        return true;
    }

    public void solve(int i, String[] words, List<String> cur) {
        if (i == words.length) {
            list.add(new ArrayList<>(cur));
            return;
        }

        cur.add(words[i]);
        solve(i + 1, words, cur);

        cur.remove(cur.size() - 1);
        solve(i + 1, words, cur);
    }
}
