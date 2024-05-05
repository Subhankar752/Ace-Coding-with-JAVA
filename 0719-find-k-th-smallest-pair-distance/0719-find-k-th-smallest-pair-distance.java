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

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int diff = a[j] - a[i];
                if (diff <= x) {
                    ans++;
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}
