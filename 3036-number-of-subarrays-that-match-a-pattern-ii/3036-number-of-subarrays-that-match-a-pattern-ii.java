class Solution {

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int ans = 0;

        int n = nums.length;
        StringBuilder s = new StringBuilder();
        StringBuilder p = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                s.append("2");
            } else if (nums[i] == nums[i + 1]) {
                s.append("0");
            } else {
                s.append("1");
            }
        }

        for (int i : pattern) {
            if (i == -1) {
                p.append("2");
            } else if (i == 0) {
                p.append("0");
            } else {
                p.append("1");
            }
        }

        String str = p.toString() + "#" + s.toString();
        int[] lps = kmp(str);

        int len = pattern.length;
        for (int i : lps) {
            if (i == len) {
                ans++;
            }
        }

        return ans;
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
