class Solution {
    public int longestSubsequence(String s, int k) {
        int val = 0, cnt = 0, pow = 1;
    for (int i = s.length() - 1; i >= 0 && val + pow <= k; --i) {
        if (s.charAt(i) == '1') {
            ++cnt;
            val += pow;
        }
        pow <<= 1;
    }
    return (int)s.chars().filter(ch -> ch == '0').count() + cnt;
    }
}