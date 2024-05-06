class Solution {

    public long appealSum(String s) {
        int n = s.length();
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) last[i] = -1;

        long cur = 0, res = 0;
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            cur += i - last[idx];
            last[idx] = i;
            res += cur;
        }
        return res;
    }
}
