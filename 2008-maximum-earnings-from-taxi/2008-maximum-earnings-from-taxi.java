class Solution {
    long[] memo;

    public long maxTaxiEarnings(int size, int[][] rides) {
        Arrays.sort(rides, (a, b) -> (a[0] - b[0])); //Sort on the basis of start time.
        int n = rides.length;
        memo = new long[n];
        Arrays.fill(memo, -1);
        return find(0, n, rides);
    }

    public long find(int i, int n, int[][] rides) {
        if (i == n || i == -1) return 0;

        if (memo[i] != -1) return memo[i];

        long x1 = find(i + 1, n, rides); //Ignore
        int ind = find(rides[i][1], i + 1, n - 1, rides);
        long x2 = (rides[i][1] - rides[i][0] + rides[i][2]) + find(ind, n, rides);

        return memo[i] = Math.max(x1, x2);
    }

    public int find(int val, int low, int high, int[][] rides) {
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (rides[mid][0] >= val) {
                res = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return res;
    }
}
