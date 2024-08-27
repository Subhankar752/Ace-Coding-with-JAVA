class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        int l = 0;
        int r = 1000000;
        int ans = 0;
        Arrays.sort(nums);

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = solve(nums, mid);

            if (val >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public int solve(int[] a, int x) {
        int ans = 0;
        int n = a.length;
        
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && a[j] <= a[i] + x) j++;
            ans += j - i - 1;
        }

        return ans;
    }
}
