class Solution {

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        String s1 = a + "#" + s;
        int[] kmp1 = kmp(s1);

        String s2 = b + "#" + s;
        int[] kmp2 = kmp(s2);

        List<Integer> idx1 = new ArrayList<>();
        List<Integer> idx2 = new ArrayList<>();

        for (int i = 0; i < kmp1.length; i++) {
            if (kmp1[i] == a.length()) {
                idx1.add(i - (2 * a.length()));
            }
        }

        for (int i = 0; i < kmp2.length; i++) {
            if (kmp2[i] == b.length()) {
                idx2.add(i - (2 * b.length()));
            }
        }

        List<Integer> ans = new ArrayList<>();
        Collections.sort(idx2);

        for (int i : idx1) {
            int left_limit = Math.max(0, i - k);
            int right_limit = Math.min(s.length() - 1, i + k);

            int lowerBoundIndex = lowerBound(idx2, left_limit);

            if (lowerBoundIndex < idx2.size() && idx2.get(lowerBoundIndex) <= right_limit) {
                ans.add(i);
            }
        }

        return ans;
    }

    private int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1, result = list.size();

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public int[] kmp(String s) {
        int[] lps = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int prevIdx = lps[i - 1];

            while (prevIdx > 0 && s.charAt(i) != s.charAt(prevIdx)) {
                prevIdx = lps[prevIdx - 1];
            }

            lps[i] = prevIdx + (s.charAt(i) == s.charAt(prevIdx) ? 1 : 0);
        }

        return lps;
    }
}
