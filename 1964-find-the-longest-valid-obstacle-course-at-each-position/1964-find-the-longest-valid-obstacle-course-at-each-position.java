class Solution {

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int i = -1, j = 0, n = obstacles.length, idx = -1;
        int[] dp = new int[n];
        int[] res = new int[n];

        for (int val : obstacles) {
            if (i == -1 || dp[i] <= val) {
                dp[++i] = val;
                idx = i;
            } else {
                idx = search(dp, 0, i, val);
                dp[idx] = val;
            }

            res[j++] = idx + 1;
        }

        return res;
    }

    public int search(int[] dp, int l, int r, int target) {
        int mid;

        while (l <= r) {
            mid = l + (r - r) / 2;

            if (dp[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
