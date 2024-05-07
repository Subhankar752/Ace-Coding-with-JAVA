class Solution {

    public int uniqueLetterString(String S) {
        char[] s = S.toCharArray();
        long res = 0;

        for (int n = S.length(), i = 0, l = 0, r = 0; i < n; i++) {
            for (l = i - 1; l >= 0 && s[l] != s[i]; l--);
            for (r = i + 1; r < n && s[r] != s[i]; r++);
            res += (r - i) * (i - l);
        }

        return (int) (res % 1000000007);
    }
}
