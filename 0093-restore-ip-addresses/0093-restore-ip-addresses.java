class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, 0, res, new StringBuilder());
        return res;
    }

    public void dfs(String s, int index, int sum, List<String> res, StringBuilder sb) {
        if (index == s.length() && sum == 4) {
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        for (int i = index; i < s.length() && i < index + 3; i++) {
            String sub = s.substring(index, i + 1);
            if (sub.charAt(0) == '0' && i - index > 0) {
                return;
            }
            if (Integer.valueOf(sub) > 255) {
                return;
            }

            int len = sb.length();
            sb.append(sub);
            sb.append(".");
            dfs(s, i + 1, sum + 1, res, sb);
            sb.delete(len, sb.length());
        }
    }
}
