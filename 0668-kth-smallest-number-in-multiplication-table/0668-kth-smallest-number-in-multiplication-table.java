class Solution {

    public int findKthNumber(int m, int n, int k) {
        int l = 1;
        int r = m * n;
        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int count = solve(mid, m, n);

            if (count >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public int solve(int mid, int m, int n) {
        int ans = 0;

        for (int i = 1; i <= m; i++) {
            int val = mid / i;
            ans += Math.min(n, val);
        }

        return ans;
    }
}
