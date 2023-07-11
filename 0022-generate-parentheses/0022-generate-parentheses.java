class Solution {
    List<String> ans;
    int n;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        this.n = n;
        solve(n, 0, 0, "");

        return ans;
    }

    public void solve(int n, int open, int close, String asf) {
        if (asf.length() == 2 * n) {
            ans.add(asf);
            return;
        }

        if (open < n) {
            solve(n, open + 1, close, asf + "(");
        }
        if (close < open) {
            solve(n, open, close + 1, asf + ")");
        }
    }
}
