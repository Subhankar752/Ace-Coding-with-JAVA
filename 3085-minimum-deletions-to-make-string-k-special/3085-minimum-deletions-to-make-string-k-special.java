class Solution {
    int[][] dp;

    public int minimumDeletions(String word, int k) {
        dp = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = -1;
            }
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            list.add(m.getValue());
        }
        Collections.sort(list);
        return solve(0, list.size() - 1, k, list);
    }

    public int solve(int i, int j, int k, List<Integer> list) {
        if (i == j) {
            return 0;
        }

        if (Math.abs(list.get(j) - list.get(i)) <= k) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int val1 = list.get(i) + solve(i + 1, j, k, list);
        int val2 = list.get(j) - (k + list.get(i)) + solve(i, j - 1, k, list);

        return dp[i][j] = Math.min(val1, val2);
    }
}
