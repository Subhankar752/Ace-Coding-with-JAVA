class Solution {
    List<String> ans;

    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        solve(0, s, wordDict, new StringBuilder());
        return ans;
    }

    public void solve(int idx, String s, List<String> words, StringBuilder sb) {
        if (idx == s.length()) {
            ans.add(sb.toString().trim());
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String substr = s.substring(idx, i + 1);
            if (words.contains(substr)) {
                sb.append(substr);
                sb.append(" ");
                solve(i + 1, s, words, sb);
                sb.delete(sb.length() - 1, sb.length());
                sb.delete(sb.length() - substr.length(), sb.length());
            }
        }
    }
}
