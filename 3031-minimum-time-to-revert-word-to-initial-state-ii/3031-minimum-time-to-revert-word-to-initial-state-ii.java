class Solution {
    int[] lps;

    public int minimumTimeToInitialState(String word, int k) {
        lps = new int[word.length()];
        kmp(word);

        int n = word.length();
        int ans = lps[n - 1];

        while (ans > 0 && (n - ans) % k > 0) {
            ans = lps[ans - 1];
        }

        if ((n - ans) % k == 0) {
            return (n - ans) / k;
        }

        return (int) Math.ceil(n / (k * 1.0));
    }

    public void kmp(String s) {
        int n = s.length();

        for (int i = 1; i < n; i++) {
            int prevIdx = lps[i - 1];

            while (prevIdx > 0 && s.charAt(i) != s.charAt(prevIdx)) {
                prevIdx = lps[prevIdx - 1];
            }

            lps[i] = prevIdx + (s.charAt(i) == s.charAt(prevIdx) ? 1 : 0);
        }
    }
}
