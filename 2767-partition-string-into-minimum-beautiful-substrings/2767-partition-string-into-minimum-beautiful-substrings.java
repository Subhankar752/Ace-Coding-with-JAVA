class Solution {
    int res = Integer.MAX_VALUE;

    public int minimumBeautifulSubstrings(String s) {
        backtrack(s, 0, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void backtrack(String s, int startIdx, int count) {
        if (startIdx >= s.length()) {
            res = Math.min(res, count);
            return;
        }
        for (int i = startIdx; i < s.length(); i++) {
            String sub = s.substring(startIdx, i + 1);
            if (!sub.startsWith("0") && powerOfFive(sub)) {
                backtrack(s, i + 1, count + 1);
            }
        }
    }

    private boolean powerOfFive(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            num |= (c - '0') << (s.length() - 1 - i);
        }
        while (num > 1 && num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
